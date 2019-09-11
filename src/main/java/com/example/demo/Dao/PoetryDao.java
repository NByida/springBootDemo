package com.example.demo.Dao;

import com.example.demo.Entity.Poetry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PoetryDao {

    @Select("SELECT * FROM Poetry WHERE name = #{name}")
    Poetry findPoetryByName(@Param("name") String name);
}
