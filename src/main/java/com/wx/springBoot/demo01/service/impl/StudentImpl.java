package com.wx.springBoot.demo01.service.impl;

import com.wx.springBoot.demo01.mapper.StuMapper;
import com.wx.springBoot.demo01.model.pojo.Student;
import com.wx.springBoot.demo01.service.StudentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author wangxin
 * @Title
 * @Description
 * @date 2019-11-08 10:36
 */
@Repository()
public class StudentImpl implements StudentService {

    private static final Logger logger = LogManager.getLogger(StudentImpl.class);

    @Autowired
    private StuMapper studentMapper;

    @Override
    public Student update(Student student) {
        this.studentMapper.update(student);
        return this.studentMapper.queryStudentBySno(student.getSno());
    }

    @Override
    public void deleteStudentBySno(String sno) {
        this.studentMapper.deleteStudentBySno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }
}
