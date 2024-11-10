package com.test.service.impl;

import com.test.dao.SeriesMapper;
import com.test.dao.UserMapper;
import com.test.obj.Lunbo;
import com.test.obj.Series;
import com.test.service.SeriesSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeriesSericeimpl implements SeriesSerice {
    @Autowired
    private SeriesMapper seriesMapper;
    @Override
    public List<Series> list() {
        return seriesMapper.list();
    }

    @Override
    public List<Lunbo> listlunbo(Lunbo lunbo) {
        return seriesMapper.listlunbo(lunbo);
    }


}
