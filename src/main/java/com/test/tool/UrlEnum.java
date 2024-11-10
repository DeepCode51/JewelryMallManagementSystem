package com.test.tool;

public enum  UrlEnum {
    SERIES("D:\\IDEA\\Hello\\Testdemo\\src\\main\\webapp\\img\\series\\"),
    User_icon("D:\\IDEA\\Hello\\Testdemo\\src\\main\\webapp\\img\\photo\\"),
    Goods_icon("D:\\IDEA\\Hello\\Testdemo\\src\\main\\webapp\\img\\goods\\"),
    Shop_icon("D:\\IDEA\\Hello\\Testdemo\\src\\main\\webapp\\img\\scert\\");


    private String url;
    UrlEnum(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
