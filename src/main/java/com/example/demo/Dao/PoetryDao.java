package com.example.demo.Dao;

import com.example.demo.Entity.Poetry;
import com.example.demo.Utils.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;


import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PoetryDao {

    @Select("SELECT * FROM Poetry WHERE name = #{name}")
    Poetry findPoetryByName(@Param("name") String name);

//    @Select("SELECT * FROM Poetry WHERE name like #{name}'%'")
    @Select("SELECT * FROM Poetry WHERE name like CONCAT('%',#{name},'%')")
    List<Poetry> findPoetryByNameLike(@Param("name") String name);

    PageResult findPage(PageRequest pageRequest);

}
