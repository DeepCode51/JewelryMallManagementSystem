package com.test.service;

import com.test.obj.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminSeriesService {
    public List<Classify> getClassify();
    ResultMap<List<Series>> series_list(SeriesPage page);
    ResultMap<List<Series>> series_classify(SeriesPage page);
    Series search_id(Integer id);
    int update(Series series);
    int upload(MultipartFile multipartFile, int id);
    int delete(int id);
    int insert(Series series);
    ResultMap<List<Series>> search(SeriesPage page, String name);
}
