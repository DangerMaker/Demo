package com.compass.common.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey
    @NonNull
    public String cid = "1";
    public String province;
    public int sex;
    public String city;
    public String iscs;
    public String name;
    public String state;
    public String country;
    public String imageid;
    public String mobile;
    public String realname;
    public String tid;
    public String token;
    public String auths;
    public int level;

    public boolean current = false;

    public static User parser(Intent intent){
        User user = new User();
        user.level = intent.getIntExtra("level", -1);
        user.auths = intent.getStringExtra("auths");
        user.cid = intent.getStringExtra("cid");
        user.tid = intent.getStringExtra("tid");
        user.token = intent.getStringExtra("token");
        user.mobile = intent.getStringExtra("mobile");
        user.realname = intent.getStringExtra("realname");
        user.current = true;

        Bundle bundle = intent.getBundleExtra("config");
        if(bundle != null){
            user.province = bundle.getString("province");
            user.sex = bundle.getInt("sex");
            user.city = bundle.getString("city");
            user.iscs = bundle.getString("iscs");
            user.name = bundle.getString("name");
            user.state = bundle.getString("state");
            user.country = bundle.getString("country");
            user.imageid = bundle.getString("imageid");
        }
        return user;
    }

    @Override
    public String toString() {
        return "User{" + '\n' +
                "cid='" + cid + '\n' +
                ", province='" + province + '\n' +
                ", sex=" + sex + '\n' +
                ", city='" + city + '\n' +
                ", iscs='" + iscs + '\n' +
                ", name='" + name + '\n' +
                ", state='" + state + '\n' +
                ", country='" + country + '\n' +
                ", imageid='" + imageid + '\n' +
                ", mobile='" + mobile + '\n' +
                ", realname='" + realname + '\n' +
                ", tid='" + tid + '\n' +
                ", token='" + token + '\n' +
                ", auths='" + auths + '\n' +
                ", level=" + level + '\n' +
                ", current=" + current +'\n' +
                '}';
    }
}
