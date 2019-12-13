package com.compass.market.hangqing;

import com.compass.market.model.PlateMarketEntity;
import com.compass.market.model.StockMarketEntity;
import com.ez08.eznet.custom.support.EzMessage;

import java.util.ArrayList;
import java.util.List;

public class HangQingParser {

    public static List<PlateMarketEntity> parsePlateList(EzMessage[] ezMessages) {
        List<PlateMarketEntity> boardList = null;
        if (ezMessages != null) {
            boardList = new ArrayList<>();
            for (int i = 0; i < ezMessages.length; i++) {
                PlateMarketEntity entity = parsePlate(ezMessages[i]);
                boardList.add(entity);
            }
        }

        return boardList;
    }

    public static List<StockMarketEntity> parseStockList(EzMessage[] ezMessages) {
        List<StockMarketEntity> stockList = null;
        if (ezMessages != null) {
            stockList = new ArrayList<>();
            for (int i = 0; i < ezMessages.length; i++) {
                StockMarketEntity entity = parseStock(ezMessages[i]);
                stockList.add(entity);
            }
        }

        return stockList;
    }

    private static PlateMarketEntity parsePlate(EzMessage msg) {
        PlateMarketEntity entity = new PlateMarketEntity();
        String boardcode = msg.getKVData("boardcode").getStringWithDefault("");
        entity.setBoardcode(boardcode);
        String boardname = msg.getKVData("boardname").getStringWithDefault("");
        entity.setBoardname(boardname);
        int current = msg.getKVData("current").getInt32();
        entity.setCurrent(current);
        int lastclose = msg.getKVData("lastclose").getInt32();
        entity.setLastclose(lastclose);
        int hsrate = msg.getKVData("hsrate").getInt32();
        entity.setHsrate(hsrate);
        String firststockcode = msg.getKVData("firststockcode").getStringWithDefault("");
        entity.setFirststockcode(firststockcode);
        String firststockname = msg.getKVData("firststockname").getStringWithDefault("");
        entity.setFirststockname(firststockname);
        int firststockzf = msg.getKVData("firststockzf").getInt32();
        entity.setFirststockzf(firststockzf);
        int exp = msg.getKVData("exp").getInt32();
        entity.setExp(exp);
        return entity;
    }

    private static StockMarketEntity parseStock(EzMessage msg) {
        if(msg==null){
            return null;
        }
        StockMarketEntity entity = new StockMarketEntity();
        if(msg.getKVData("secuname")!=null) {
            String name = msg.getKVData("secuname").getStringWithDefault("");
            entity.setSecuname(name);
        }else{
            entity.setSecuname("--");
        }
        if(msg.getKVData("secucode")!=null) {
            String code = msg.getKVData("secucode").getStringWithDefault("");
//            code= StockUtils.getStockCode(code);
            entity.setSecucode(code);
        }else{
            entity.setSecucode("--");
        }

        if(msg.getKVData("state")!=null) {
            int state = msg.getKVData("state").getInt32();
            entity.setState(state);
        }else{
            entity.setState(0);
        }

        if(msg.getKVData("type") != null) {
            int type = msg.getKVData("type").getInt32();
            entity.setType(type);
        }else{
            entity.setType(0);
        }

        if(msg.getKVData("current") != null) {
            int current = msg.getKVData("current").getInt32();
            entity.setCurrent(current);
        }else{
            entity.setCurrent(0);
        }

        if(msg.getKVData("lastclose") != null) {
            int lastclose = msg.getKVData("lastclose").getInt32();
            entity.setLastclose(lastclose);
        }else{
            entity.setLastclose(0);
        }

        if(msg.getKVData("exp") != null) {
            int exp = msg.getKVData("exp").getInt32();
            entity.setExp(exp);
        }else{
            entity.setExp(0);
        }
        return entity;
    }
}
