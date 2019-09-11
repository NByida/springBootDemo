package com.example.demo.Services;

import com.example.demo.Dao.PoetryDao;
import com.example.demo.Entity.Poetry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String getLikePoetry(String name){
        ArrayList<Poetry> list=poetryDao.findPoetryByNameLike(name);
        String result="共找到"+list.size()+"条数据</br>";
        Iterator iterator=list.iterator();
        int index=1;
        while (iterator.hasNext()){
            result=result+(index++)+((Poetry)iterator.next()).getName()+"</br>";
        }
        result="<html>"+result+"</html>";
        return result;
    }


}
