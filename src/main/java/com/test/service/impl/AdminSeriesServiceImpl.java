package com.test.service.impl;

import com.test.dao.AdminSeriesMapper;
import com.test.obj.*;
import com.test.service.AdminSeriesService;
import com.test.tool.UploadTool;
import com.test.tool.UrlEnum;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminSeriesServiceImpl implements AdminSeriesService {
    @Autowired
    AdminSeriesMapper adminSeriesMapper;

    @Override
    public Series search_id(Integer id) {
        return adminSeriesMapper.search_id(id);
    }

    @Override
    public int update(Series series) {
        return adminSeriesMapper.update(series);
    }

    @Override
    public ResultMap<List<Series>> series_list(SeriesPage page) {
        List<Series> list = adminSeriesMapper.series_list(page);
        int count = adminSeriesMapper.count();
        ResultMap<List<Series>> jsonMap = new ResultMap<List<Series>>(0, "success", count, list);
        return  jsonMap;
    }

    @Override
    public ResultMap<List<Series>> series_classify(SeriesPage page) {
        List<Series> list = adminSeriesMapper.search_classify(page);
        int count = adminSeriesMapper.count();
        ResultMap<List<Series>> jsonMap = new ResultMap<List<Series>>(0, "success", count, list);
        return  jsonMap;
    }

    @Override
    public List<Classify> getClassify() {
        return adminSeriesMapper.getClassify();
    }

    @Override
    public int delete(int id) {
        return adminSeriesMapper.delete(id);
    }

    @Override
    public int upload(MultipartFile multipartFile, int id) {
        String url = null;
        try {
            url = UploadTool.upload(multipartFile, UrlEnum.User_icon.getUrl());
        }catch (Exception e){
            e.printStackTrace();
        }
        Series series = new Series();
        series.setUrl(url);
        series.setSeriesid(id);

        return adminSeriesMapper.insert_pic(series);
    }

    @Override
    public ResultMap<List<Series>> search(SeriesPage page, String name) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name",name);
        map.put("start",page.getStart());
        map.put("rows",page.getRows());
        List<Series> list = adminSeriesMapper.search(map);
        int count = adminSeriesMapper.count();
        ResultMap<List<Series>> jsonMap = new ResultMap<List<Series>>(0, "success", count, list);
        return  jsonMap;
    }

    @Override
    public int insert(Series series) {
        return adminSeriesMapper.insert(series);
    }
}
