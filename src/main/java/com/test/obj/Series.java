package com.test.obj;

public class Series {
    private int seriesid;
    private int classify;
    private String name;
    private String url;

    public int getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(int seriesid) {
        this.seriesid = seriesid;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Series{" +
                "seriesid=" + seriesid +
                ", classify=" + classify +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
