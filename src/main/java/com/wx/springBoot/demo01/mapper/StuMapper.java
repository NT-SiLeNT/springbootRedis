package com.wx.springBoot.demo01.mapper;

import com.wx.springBoot.demo01.model.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

/**
 * @author wangxin
 * @Title
 * @Description
 * @date 2019-11-08 10:58
 */
@Mapper
@Component
@CacheConfig(cacheNames = "student")
public interface StuMapper {
    @Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    int update(Student student);

    @Delete("delete from student where sno=#{sno}")
    void deleteStudentBySno(String sno);

    @Select("select * from student where sno=#{sno}")
    @Results(id = "student",
            value = {
            @Result(property = "sno", column = "sno", javaType = String.class),
            @Result(property = "name", column = "sname", javaType = String.class),
            @Result(property = "sex", column = "ssex", javaType = String.class)
            })
    Student queryStudentBySno(String sno);
}
