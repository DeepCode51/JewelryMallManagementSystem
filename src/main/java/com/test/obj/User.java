package com.test.obj;

import java.math.BigDecimal;

public class User {
    private String aid;
    private String username;
    private String userpass;
    private String call;
    private String sex;
    private String place;
    private String createtime;
    private String icon;
    private float money;
    private int able;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getAble() {
        return able;
    }

    public void setAble(int able) {
        this.able = able;
    }

    @Override
    public String toString() {
        return "User{" +
                "aid='" + aid + '\'' +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", call='" + call + '\'' +
                ", sex='" + sex + '\'' +
                ", place='" + place + '\'' +
                ", createtime='" + createtime + '\'' +
                ", icon='" + icon + '\'' +
                ", money=" + money +
                ", able=" + able +
                '}';
    }
}
