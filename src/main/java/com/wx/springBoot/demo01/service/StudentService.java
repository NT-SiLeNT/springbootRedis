package com.wx.springBoot.demo01.service;

import com.wx.springBoot.demo01.model.pojo.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author wangxin
 * @Title
 * @Description
 * @date 2019-11-06 16:13
 */
@CacheConfig(cacheNames = "student")
@Repository
public interface StudentService {
    @CachePut(key = "#p0.sno")
    Student update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteStudentBySno(String sno);

    @Cacheable(key = "#p0")
    Student queryStudentBySno(String sno);
}
