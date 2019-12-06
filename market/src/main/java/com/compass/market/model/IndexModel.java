package com.compass.market.model;

public class IndexModel {
    public String title;
    public String dianshu;
    public String updianshu;
    public String upPercent;

    public static IndexModel parser(PlateMarketEntity entity){
        IndexModel model = new IndexModel();
        model.title = entity.getBoardname();
        model.dianshu = entity.getCurrent() + "";
        model.updianshu = entity.getLastclose() + "";
        model.upPercent = entity.getHsrate() + "";
        return model;
    }
}
