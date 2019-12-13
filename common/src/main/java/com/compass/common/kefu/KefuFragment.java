package com.compass.common.kefu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.compass.common.R;
import com.compass.common.base.BaseFragment;
import com.compass.common.login.LoginActivity;
import com.compass.common.net.userauth.UserInfo;
import com.compass.common.user.StoreHelper;

public class KefuFragment extends BaseFragment implements View.OnClickListener {

    Button login;
    Button logout;
    TextView name;
    @Override
    protected int getLayoutId() {
        return R.layout.common_fragment_kefu;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login = view.findViewById(R.id.commit_login);
        logout = view.findViewById(R.id.commit_logout);
        name = view.findViewById(R.id.commit_name);
        login.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
//        UserInfo userInfo = StoreHelper.getUserInfo(mContext);
//        if(!TextUtils.isEmpty(userInfo.cid) && userInfo.cid.startsWith("T")){
//            name.setText("匿名用户");
//            login.setVisibility(View.VISIBLE);
//            logout.setVisibility(View.GONE);
//        }
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(mContext, LoginActivity.class));
    }
}
