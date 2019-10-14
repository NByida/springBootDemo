package com.example.demo.Services;

import com.example.demo.Dao.PoetryDao;
import com.example.demo.Entity.Poetry;
import com.example.demo.Utils.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryService {
    @Autowired
    PoetryDao poetryDao;


    /**
     * 诗名搜索
     * @param name
     * @param pageRequest
     * @return
     */
    public PageInfo<Poetry> getLikePoetry(String name, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.findPoetryByNameLike(name);
        PageInfo result=new PageInfo(list);
        return result;
    }


    /**
     * 全部搜索
     * @param name
     * @param pageRequest
     * @return
     */
    public PageInfo<Poetry> getAllLike(String name, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.findAll(name);
        PageInfo result=new PageInfo(list);
        return result;
    }

    /**
     * 内容搜索
     * @param name
     * @param pageRequest
     * @return
     */
    public PageInfo<Poetry> getContentLikePoetry(String name, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.findPoetryByContentLike(name);
        PageInfo result=new PageInfo(list);
        return result;
    }


    /**
     * 作者搜索
     * @param name
     * @param pageRequest
     * @return
     */
    public PageInfo<Poetry> getPoetLikePoetry(String name, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.findPoetryByAuthLike(name);
        PageInfo result=new PageInfo(list);
        return result;
    }

    public PageInfo<Poetry> getAllPoetry(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.getAllPoetry();
        PageInfo result=new PageInfo(list);
        return result;
    }

}
