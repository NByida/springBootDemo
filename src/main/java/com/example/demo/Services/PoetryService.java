package com.example.demo.Services;

import com.example.demo.Dao.PoetryDao;
import com.example.demo.Entity.Poetry;
import com.example.demo.Entity.Tag;
import com.example.demo.Utils.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    /**
     * 获取诗词的标签
     * @param pageRequest
     * @param id
     * @return
     */
    public PageInfo<Tag> getPoetryTags(PageRequest pageRequest,String id){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> list=poetryDao.getPoetryTag(id);
        PageInfo result=new PageInfo(list);
        return result;
    }

    public PageInfo<Poetry> getPoetryUnderTags(PageRequest pageRequest,String tagName){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> list=poetryDao.getPoetryByTagName(tagName);
        PageInfo result=new PageInfo(list);
        return result;
    }

    /**
     * 根据诗词id，推荐更多诗词
     * @param pageRequest
     * @param id
     * @return
     */
    public PageInfo<Poetry> getRecommend(PageRequest pageRequest,String id){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags=poetryDao.getPoetryTag(id);
        List<Poetry> poetries=new ArrayList<>();
        if(tags!=null){
            Iterator iterator=tags.iterator();
            while (iterator.hasNext()){
                String tag=((Tag)iterator.next()).getTag();
                List list=poetryDao.getPoetryByTagName3(tag,id);
                if(list!=null){
                    Iterator poetryIterator=list.iterator();
                    while (poetryIterator.hasNext()){
                        ((Poetry)poetryIterator.next()).setTag(tag);
                    }
                    poetries.addAll(list);
                }
            }
        }
        PageInfo result=new PageInfo(poetries);
        return result;
    }

}
