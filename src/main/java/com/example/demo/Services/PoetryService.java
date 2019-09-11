package com.example.demo.Services;

import com.example.demo.Dao.PoetryDao;
import com.example.demo.Entity.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoetryService {
    @Autowired
    PoetryDao poetryDao;

    public Poetry getPoetry(String name){
        return poetryDao.findPoetryByName(name);
    }

}
