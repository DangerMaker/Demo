package com.compass.market;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Looper;

import com.compass.common.net.NetInterface;
import com.compass.common.net.Response;
import com.compass.common.net.exception.CustomException;
import com.compass.common.user.User;
import com.compass.common.utils.MD5;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.PlateMarketEntity;
import com.compass.market.model.StockMarketEntity;
import com.ez08.support.net.EzMessage;
import com.ez08.support.net.EzNet;
import com.ez08.support.net.NetManager;
import com.ez08.support.net.NetResponseHandler2;
import com.ez08.support.util.EzValue;
import com.ez08.tools.IntentTools;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import static com.compass.common.net.RemoteRepository.RESPONSE;

public class MarketRemoteRepository {

    public static int RESPONSE = 1001;
    public static int GET_STOCK_RESPONSE = 1002;

    @SuppressLint("HandlerLeak")
    public static Observable<Response<HangQingResp>> getHangqing() {

        return Observable.create(new ObservableOnSubscribe<Response<HangQingResp>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<HangQingResp>> emitter) throws Exception {
//                NetInterface.getMarketData(new NetResponseHandler2() {
//                    @Override
//                    public void receive(int what, boolean result, Intent intent) {
//
//                    }
//                },RESPONSE);
                HangQingResp resp = new HangQingResp();
                StockMarketEntity stock = new StockMarketEntity();
                List<StockMarketEntity> list1 = new ArrayList<>();
                list1.add(stock.getTest());
                list1.add(stock.getTest());
                list1.add(stock.getTest());
                list1.add(stock.getTest());
                list1.add(stock.getTest());
                resp.stocklist1 = list1;
                resp.stocklist2 = list1;
                resp.kclist = list1;

                PlateMarketEntity plate = new PlateMarketEntity();
                List<PlateMarketEntity> list2 = new ArrayList<>();
                list2.add(plate.getTest());
                list2.add(plate.getTest());
                list2.add(plate.getTest());
                list2.add(plate.getTest());
                resp.boardlist0 = list2;
                resp.boardlist1 = list2;
                resp.boardlist2 = list2;
                Response<HangQingResp> respResponse = new Response<>();
                respResponse.setData(resp);
                emitter.onNext(respResponse);
            }
        });
    }

    @SuppressLint("HandlerLeak")
    public static Observable<Response<List<StockMarketEntity>>> getStockQuery() {
        return Observable.create(new ObservableOnSubscribe<Response<List<StockMarketEntity>>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<List<StockMarketEntity>>> emitter) throws Exception {
                NetInterface.getStockBrief(new NetResponseHandler2(Looper.getMainLooper()) {
                    @Override
                    public void receive(int what, boolean result, Intent intent) {
                        List<StockMarketEntity> list = new ArrayList<>();
                        EzValue ezValue = IntentTools.safeGetEzValueFromIntent(
                                intent, "list");
                        EzMessage[] msges = ezValue.getMessages();
                        StockMarketParser parser = new StockMarketParser();
                        for (int i = 0; i < msges.length; i++) {
                            StockMarketEntity entity = parser.parse(msges[i]);
                            if (entity != null) {
                                list.add(entity);
                            }
                        }

                        Response<List<StockMarketEntity>> response = new Response<>();
                        response.setData(list);
                        emitter.onNext(response);
                    }
                }, GET_STOCK_RESPONSE, "SHHQ000001,SZHQ399001,SZHQ399006,SZHQ399005");
            }
        });
    }

}
