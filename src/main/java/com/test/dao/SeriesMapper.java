package com.test.dao;

import com.test.obj.Lunbo;
import com.test.obj.Series;

import java.util.List;

public interface SeriesMapper {
    List<Series> list();
    List<Lunbo> listlunbo(Lunbo lunbo);
}
