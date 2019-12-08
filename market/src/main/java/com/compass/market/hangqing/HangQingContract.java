package com.compass.market.hangqing;

import com.compass.common.base.BasePresenter;
import com.compass.common.base.BaseView;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.ItemStock;
import com.compass.market.model.StockMarketEntity;

import java.util.List;

public class HangQingContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showMarkets(HangQingResp resp);

        void showMarketsEmpty();

        void showIndexs(List<StockMarketEntity> stocks);
    }

    interface Presenter extends BasePresenter {

        //剩下的所有市场
        void loadMarkets();

        //上边4个指数
        void loadIndexs();
    }
}
