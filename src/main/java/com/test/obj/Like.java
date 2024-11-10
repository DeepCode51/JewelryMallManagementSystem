package com.test.obj;

public class Like {
    private String uid;
    private String gno;
    private String gname;
    private String url;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Like{" +
                "uid='" + uid + '\'' +
                ", gno='" + gno + '\'' +
                ", gname='" + gname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
