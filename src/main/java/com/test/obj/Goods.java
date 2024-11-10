package com.test.obj;

public class Goods {
    private String gno;
    private int typeid;
    private int seriesid;
    private String gname;
    private float gprice;
    private String gbrand;
    private float gweight;
    private String gmaterial;
    private String gmainimg;
    private String gbig;
    private String gintro;
    private int stat;
    private String shopid;
    private String ctime;

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(int seriesid) {
        this.seriesid = seriesid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public float getGprice() {
        return gprice;
    }

    public void setGprice(float gprice) {
        this.gprice = gprice;
    }

    public String getGbrand() {
        return gbrand;
    }

    public void setGbrand(String gbrand) {
        this.gbrand = gbrand;
    }

    public float getGweight() {
        return gweight;
    }

    public void setGweight(float gweight) {
        this.gweight = gweight;
    }

    public String getGmaterial() {
        return gmaterial;
    }

    public void setGmaterial(String gmaterial) {
        this.gmaterial = gmaterial;
    }

    public String getGmainimg() {
        return gmainimg;
    }

    public void setGmainimg(String gmainimg) {
        this.gmainimg = gmainimg;
    }

    public String getGbig() {
        return gbig;
    }

    public void setGbig(String gbig) {
        this.gbig = gbig;
    }

    public String getGintro() {
        return gintro;
    }

    public void setGintro(String gintro) {
        this.gintro = gintro;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gno='" + gno + '\'' +
                ", typeid=" + typeid +
                ", seriesid=" + seriesid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gbrand='" + gbrand + '\'' +
                ", gweight=" + gweight +
                ", gmaterial='" + gmaterial + '\'' +
                ", gmainimg='" + gmainimg + '\'' +
                ", gbig='" + gbig + '\'' +
                ", gintro='" + gintro + '\'' +
                ", stat=" + stat +
                ", shopid='" + shopid + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
