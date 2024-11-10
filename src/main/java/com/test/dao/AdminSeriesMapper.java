package com.test.dao;

import com.test.obj.Classify;
import com.test.obj.Series;
import com.test.obj.SeriesPage;

import java.util.List;
import java.util.Map;

public interface AdminSeriesMapper {
    List<Classify> getClassify();
    List<Series> series_list(SeriesPage page);
    int count();
    List<Series> search_classify(SeriesPage page);
    Series search_id(Integer id);
    int update(Series series);
    int insert_pic(Series series);
    int delete(int id);
    int insert(Series series);
    List<Series> search(Map<String, Object> map);
}
