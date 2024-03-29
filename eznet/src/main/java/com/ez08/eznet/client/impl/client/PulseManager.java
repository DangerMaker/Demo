package com.ez08.eznet.client.impl.client;

import com.ez08.eznet.client.impl.exceptions.DogDeadException;
import com.ez08.eznet.client.sdk.client.OkSocketOptions;
import com.ez08.eznet.client.sdk.client.bean.IPulse;
import com.ez08.eznet.client.sdk.client.connection.IConnectionManager;
import com.ez08.eznet.core.iocore.interfaces.IPulseSendable;
import com.ez08.eznet.interfacies.basic.AbsLoopThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xuhao on 2017/5/18.
 */

public class PulseManager implements IPulse {
    /**
     * 数据包发送器
     */
    private volatile IConnectionManager mManager;
    /**
     * 心跳数据包
     */
    private IPulseSendable mSendable;
    /**
     * 连接参数
     */
    private volatile OkSocketOptions mOkOptions;
    /**
     * 当前频率
     */
    private volatile long mCurrentFrequency;
    /**
     * 当前的线程模式
     */
    private volatile OkSocketOptions.IOThreadMode mCurrentThreadMode;
    /**
     * 是否死掉
     */
    private volatile boolean isDead = false;
    /**
     * 允许遗漏的次数
     */
    private volatile AtomicInteger mLoseTimes = new AtomicInteger(-1);

    private PulseThread mPulseThread = new PulseThread();

    PulseManager(IConnectionManager manager, OkSocketOptions okOptions) {
        mManager = manager;
        mOkOptions = okOptions;
        mCurrentThreadMode = mOkOptions.getIOThreadMode();
    }

    public synchronized IPulse setPulseSendable(IPulseSendable sendable) {
        if (sendable != null) {
            mSendable = sendable;
        }
        return this;
    }

    public IPulseSendable getPulseSendable() {
        return mSendable;
    }

    @Override
    public synchronized void pulse() {
        privateDead();
        updateFrequency();
        if (mCurrentThreadMode != OkSocketOptions.IOThreadMode.SIMPLEX) {
            if (mPulseThread.isShutdown()) {
                mPulseThread.start();
            }
        }
    }

    @Override
    public synchronized void trigger() {
        if (isDead) {
            return;
        }
        if (mCurrentThreadMode != OkSocketOptions.IOThreadMode.SIMPLEX && mManager != null && mSendable != null) {
            mManager.send(mSendable);
        }
    }

    public synchronized void dead() {
        mLoseTimes.set(0);
        isDead = true;
        privateDead();
    }

    private synchronized void updateFrequency() {
        if (mCurrentThreadMode != OkSocketOptions.IOThreadMode.SIMPLEX) {
            mCurrentFrequency = mOkOptions.getPulseFrequency();
            mCurrentFrequency = mCurrentFrequency < 1000 ? 1000 : mCurrentFrequency;//间隔最小为一秒
        } else {
            privateDead();
        }
    }

    @Override
    public synchronized void feed() {
        mLoseTimes.set(-1);
    }

    private void privateDead() {
        if (mPulseThread != null) {
            mPulseThread.shutdown();
        }
    }

    public int getLoseTimes() {
        return mLoseTimes.get();
    }

    protected synchronized void setOkOptions(OkSocketOptions okOptions) {
        mOkOptions = okOptions;
        mCurrentThreadMode = mOkOptions.getIOThreadMode();
        updateFrequency();
    }

    private class PulseThread extends AbsLoopThread {

        @Override
        protected void runInLoopThread() throws Exception {
            if (isDead) {
                shutdown();
                return;
            }
            if (mManager != null && mSendable != null) {
                System.out.println("getLoseTimes:" + getLoseTimes());
                if (mOkOptions.getPulseFeedLoseTimes() != -1 && mLoseTimes.incrementAndGet() >= mOkOptions.getPulseFeedLoseTimes()) {
                    mManager.disconnect(new DogDeadException("you need feed dog on time,otherwise he will die"));
                } else {
                    mManager.send(mSendable);
                }
            }

            //not safety sleep.
            Thread.sleep(mCurrentFrequency);
        }

        @Override
        protected void loopFinish(Exception e) {
        }
    }


}
