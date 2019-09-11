package com.example.demo.Dao;

import com.example.demo.Entity.Poetry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.ArrayList;

@Mapper
public interface PoetryDao {

    @Select("SELECT * FROM Poetry WHERE name = #{name}")
    Poetry findPoetryByName(@Param("name") String name);

//    @Select("SELECT * FROM Poetry WHERE name like #{name}'%'")
    @Select("SELECT * FROM Poetry WHERE name like CONCAT('%',#{name},'%')")
    ArrayList<Poetry> findPoetryByNameLike(@Param("name") String name);
}
