package com.compass.common.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.compass.common.R;
import com.compass.common.base.BaseActivity;
import com.compass.common.local.UserDatabase;
import com.compass.common.widget.MyDelEditetext;

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {

    MyDelEditetext username;
    MyDelEditetext password;
    Button loginButton;

    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_login);

        username = findViewById(R.id.userName_edit);
        password = findViewById(R.id.passWord_edit);
        loginButton = findViewById(R.id.load_btn);
        loginButton.setOnClickListener(this);

        presenter = new LoginPresenter(UserDatabase.getInstance(context));
        setPresenter(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void onClick(View view) {
        if(view == loginButton){
            String name = username.getText().toString();
            String pass = password.getText().toString();
            presenter.login(name,pass);
        }
    }
}
