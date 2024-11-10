package com.test.obj;

public class Order {
    private int oid;
    private String gno;
    private String uid;
    private String gname;
    private float gprice;
    private String pname;
    private String oplace;
    private String gbig;
    private String pcall;
    private String stat;
    private String ourl;
    private String otime;

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getOplace() {
        return oplace;
    }

    public void setOplace(String oplace) {
        this.oplace = oplace;
    }

    public String getGbig() {
        return gbig;
    }

    public void setGbig(String gbig) {
        this.gbig = gbig;
    }

    public String getPcall() {
        return pcall;
    }

    public void setPcall(String pcall) {
        this.pcall = pcall;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getOurl() {
        return ourl;
    }

    public void setOurl(String ourl) {
        this.ourl = ourl;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", gno='" + gno + '\'' +
                ", uid='" + uid + '\'' +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", pname='" + pname + '\'' +
                ", oplace='" + oplace + '\'' +
                ", gbig='" + gbig + '\'' +
                ", pcall='" + pcall + '\'' +
                ", stat='" + stat + '\'' +
                ", ourl='" + ourl + '\'' +
                ", otime='" + otime + '\'' +
                '}';
    }
}
