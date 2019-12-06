package com.compass.market.hangqing;

import com.compass.common.base.BasePresenter;
import com.compass.common.base.BaseView;
import com.compass.market.model.HangQingResp;

public class HangContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void setList(HangQingResp resp);

    }

    interface Presenter extends BasePresenter {
        void getList();
    }
}
