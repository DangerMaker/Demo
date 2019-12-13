package com.compass.common.user;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.ez08.eznet.custom.support.EzIntent;

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

    public static User parser(EzIntent intent){
        User user = new User();
        user.level = intent.getExtraDataInt32("level", -1);
        user.auths = intent.getExtraDataString("auths","");
        user.cid = intent.getExtraDataString("cid","");
        user.tid = intent.getTID();
        user.token = intent.getExtraDataString("token","");
        user.mobile = intent.getExtraDataString("mobile","");
        user.realname = intent.getExtraDataString("realname","");
        user.current = true;
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
