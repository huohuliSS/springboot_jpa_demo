package com.qhw.springboot_jpa_demo.repository;

import com.qhw.springboot_jpa_demo.pojo.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by asus on 2019/11/14  16:48
 */
public interface PeopleRepository extends JpaRepository<People, Long> {

    //根据方法名自动推导出要执行查询

    //根据用户名称查询
    public List<People> findByNameContains(String name);

    //根据用户名、年龄等于
    public People findByNameEqualsAndAgeEquals(String name, Integer age);

    //查询用户名等于 sunny  JPQL   面向对象查询语句
    @Query("select p from People p where p.name=:name")
    public People xxxnameis(String name);

    //根据用户名、年龄
    @Query("select p from People p where p.name=:name and p.age=:age")
    public People yyynameandage(String name, Integer age);

    //使用原始sql   nativeQuery = true 指定使用原始sql
    @Query(nativeQuery = true, value = "select * from tb_people where length(name)=5")
    public List<People> findnamelength();

    @Query(nativeQuery = true,value = "select * from tb_people where name like %:name%")
    public List<People> findListByName(@Param("name") String name);

}
