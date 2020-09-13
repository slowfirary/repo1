package com.djs.provider.dao;

import com.djs.provider.entity.Depart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepartDao  {

    @Insert("insert into depart(name) values(#{name})")
    void save(Depart depart);

    @Delete("delete from depart where id = #{id}")
    void deleteById(int id);

    @Update("update depart set name = #{name} where id = #{id}")
    void modifyDepart(Depart depart);

    @Select("select * from depart where id = #{id}")
    Depart getDepartById(int id);

    @Select("select * from depart")
    List<Depart> findAll();
}
