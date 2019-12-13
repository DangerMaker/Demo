package com.compass.market;

import android.annotation.SuppressLint;
import android.util.Log;

import com.compass.common.net.Client;
import com.compass.common.net.Response;
import com.compass.common.net.exception.CustomException;
import com.compass.common.net.userauth.Callback;
import com.compass.common.net.userauth.EzPackage;
import com.compass.market.hangqing.HangQingParser;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.StockMarketEntity;
import com.ez08.eznet.custom.support.EzIntent;
import com.ez08.eznet.custom.support.EzKeyValue;
import com.ez08.eznet.custom.support.EzMessage;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class MarketRemoteRepository {

    @SuppressLint("HandlerLeak")
    public static Observable<Response<HangQingResp>> getHangqing() {

        return Observable.create(new ObservableOnSubscribe<Response<HangQingResp>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<HangQingResp>> emitter) throws Exception {
                EzIntent intent = new EzIntent("ez08.zntr.marketpreview.q");
                Client.getInstance().send(new EzPackage(intent), new Callback() {
                    @Override
                    public void onResult(boolean success, EzIntent intent) {
                        if (success) {
                            Log.e("marketpreview",intent.toEzMessage().description());
                            HangQingResp resp = new HangQingResp();
                            EzMessage[] boardlist0 = intent.getExtraDataEzMessages("boardlist0");
                            resp.boardlist0 = HangQingParser.parsePlateList(boardlist0);
                            EzMessage[] boardlist1 = intent.getExtraDataEzMessages("boardlist1");
                            resp.boardlist1 = HangQingParser.parsePlateList(boardlist1);
                            EzMessage[] boardlist2 = intent.getExtraDataEzMessages("boardlist2");
                            resp.boardlist2 = HangQingParser.parsePlateList(boardlist2);
                            EzMessage[] kclist = intent.getExtraDataEzMessages("kclist");
                            resp.kclist = HangQingParser.parseStockList(kclist);
                            EzMessage[] stocklist1 = intent.getExtraDataEzMessages("stocklist1");
                            resp.stocklist1 = HangQingParser.parseStockList(stocklist1);
                            EzMessage[] stocklist2 = intent.getExtraDataEzMessages("stocklist2");
                            resp.stocklist2 = HangQingParser.parseStockList(stocklist2);

                            Response<HangQingResp> respResponse = new Response<>();
                            respResponse.setData(resp);
                            emitter.onNext(respResponse);
                        }

                    }
                });
            }
        });
    }

    @SuppressLint("HandlerLeak")
    public static Observable<Response<List<StockMarketEntity>>> getStockQuery() {
        return Observable.create(new ObservableOnSubscribe<Response<List<StockMarketEntity>>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<List<StockMarketEntity>>> emitter) {
                EzIntent intent = new EzIntent("ez08.zntr.stockbrief.q");
                intent.putExtraData(new EzKeyValue("secucodes", "SHHQ000001,SZHQ399001,SZHQ399006,SZHQ399005"));
                Client.getInstance().send(new EzPackage(intent), new Callback() {
                    @Override
                    public void onResult(boolean success, EzIntent intent) {
                        if (success) {
                            EzMessage[] list = intent.getExtraDataEzMessages("list");
                            List<StockMarketEntity> data  = HangQingParser.parseStockList(list);
                            Response<List<StockMarketEntity>> response = new Response<>();
                            response.setData(data);
                            emitter.onNext(response);
                        } else {
                            emitter.onError(CustomException.throwCommonException(intent));
                        }
                    }
                });
            }
        });
    }
}
