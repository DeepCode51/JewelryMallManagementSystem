package com.test.obj;

public class Lunbo {
    private int lunboid;
    private int seriesid;
    private String url;

    public int getLunboid() {
        return lunboid;
    }

    public void setLunboid(int lunboid) {
        this.lunboid = lunboid;
    }

    public int getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(int seriesid) {
        this.seriesid = seriesid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Lunbo{" +
                "lunboid=" + lunboid +
                ", seriesid=" + seriesid +
                ", url='" + url + '\'' +
                '}';
    }
}
