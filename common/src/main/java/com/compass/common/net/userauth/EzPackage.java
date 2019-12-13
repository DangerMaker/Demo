package com.compass.common.net.userauth;

import com.ez08.eznet.core.iocore.interfaces.ISendable;
import com.ez08.eznet.custom.support.EzCoder;
import com.ez08.eznet.custom.support.EzIntent;
import com.ez08.eznet.custom.support.EzMessage;
import com.ez08.eznet.custom.support.EzMessageFactory;

import java.nio.ByteBuffer;

public class EzPackage implements ISendable {

    private EzIntent message;
    private EzCoder coder;
    private int sn;

    public EzPackage(EzIntent ezIntent) {
        message = ezIntent;
        sn = EzMessageFactory.getSnClient();
        message.setSN(sn);
    }

    public void setCoder(EzCoder ezCoder){
        coder = ezCoder;
    }

    public int getSn() {
        return sn;
    }

    public String getAction(){
        return message.getAction();
    }

    @Override
    public byte[] parse() {
        if (message != null) {
            EzMessage ezMessage =  coder.encode(message.toEzMessage(), message.getEncFlags());
            byte[] msg = ezMessage.serializeToPB();
            ByteBuffer buffer = ByteBuffer.allocate(5 + msg.length);
            buffer.put((byte) 0xFE);
            buffer.putInt(msg.length);
            buffer.put(msg);
            return buffer.array();
        }
        return new byte[0];
    }
}
