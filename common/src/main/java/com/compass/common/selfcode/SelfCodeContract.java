package com.compass.common.selfcode;

import com.compass.common.base.BasePresenter;
import com.compass.common.base.BaseView;

public class SelfCodeContract {

    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);

        void showList(ItemStock itemStock);
    }

    interface Presenter extends BasePresenter {

        void loadSelfCode();
    }
}
