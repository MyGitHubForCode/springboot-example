package com.example.springbootexample.service;

import com.example.springbootexample.dao.ExampleDao;
import com.example.springbootexample.domain.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * ClassName:
 * Description:
 * date: 2019/8/19 0019 10:41
 *
 * @author SS
 * @since JDK 1.8
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleDao exampleDao;

    @Override
    public ArrayList queryDate() {

        ArrayList<CityModel> list = exampleDao.queryDate();
        return list;

    }
}
