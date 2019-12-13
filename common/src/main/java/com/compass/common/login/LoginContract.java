package com.compass.common.login;

import com.compass.common.base.BasePresenter;
import com.compass.common.base.BaseView;

public class LoginContract {

    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);

        void loginResult(boolean success,String message);
    }

    interface Presenter extends BasePresenter {
        void login(String name,String pwd);
    }
}
