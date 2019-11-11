package com.example.demo.Dao;

import com.example.demo.Entity.Poetry;
import com.example.demo.Entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PoetryDao {

    @Select("SELECT * FROM poetry WHERE name = #{name}")
    Poetry findPoetryByName(@Param("name") String name);


    @Select("SELECT * FROM poetry WHERE name like CONCAT('%',#{name},'%')")
    List<Poetry> findPoetryByNameLike(@Param("name") String name);

    @Select("SELECT * FROM poetry WHERE content like CONCAT('%',#{content},'%')")
    List<Poetry> findPoetryByContentLike(@Param("content") String content);

    @Select("SELECT * FROM poetry WHERE poet like CONCAT('%',#{Auth},'%')")
    List<Poetry> findPoetryByAuthLike(@Param("Auth") String Auth);

    @Select("SELECT distinct * FROM poetry WHERE content like CONCAT('%',#{query},'%') OR poet like CONCAT('%',#{query},'%') OR name like CONCAT('%',#{query},'%') ")
    List<Poetry> findAll(@Param("query") String query);

    @Select("SELECT * FROM poetry")
    List<Poetry> getAllPoetry();

    @Select("SELECT * FROM Tag WHERE petoryid = #{id}")
    List<Tag> getPoetryTag(@Param("id") String id);

    @Select("Select * from poetry where id=any(SELECT petoryid FROM Tag where tag = #{tagName})")
    List<Poetry> getPoetryByTagName(@Param("tagName") String tagName);

    @Select("Select * from poetry where id=any(SELECT petoryid FROM Tag where tag = #{tagName}  AND petoryid !=  #{id} ) order by rand() limit 3")
    List<Poetry> getPoetryByTagName3(@Param("tagName") String tagName,String id);

}
