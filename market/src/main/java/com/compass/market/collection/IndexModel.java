package com.compass.market.collection;

import com.compass.market.model.PlateMarketEntity;

public class IndexModel {
    public String title;
    public String dianshu;
    public String updianshu;
    public String upPercent;

    public IndexModel(String title) {
        this.title = title;
    }

    public IndexModel() {
    }

    public static IndexModel parser(PlateMarketEntity entity){
        IndexModel model = new IndexModel();
        model.title = entity.getBoardname();
        model.dianshu = entity.getCurrent() + "";
        model.updianshu = entity.getLastclose() + "";
        model.upPercent = entity.getHsrate() + "";
        return model;
    }
}
