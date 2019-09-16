package com.example.demo.Services;

import com.example.demo.Dao.PoetryDao;
import com.example.demo.Entity.Poetry;
import com.example.demo.Utils.PageRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PoetryService {
    @Autowired
    PoetryDao poetryDao;

    public Poetry getPoetry(String name){
        return poetryDao.findPoetryByName(name);
    }

    public PageInfo<Poetry> getLikePoetry(String name, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.findPoetryByNameLike(name);
        PageInfo result=new PageInfo(list);
        return result;
    }


}
