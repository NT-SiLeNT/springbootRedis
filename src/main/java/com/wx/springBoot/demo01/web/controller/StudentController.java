package com.wx.springBoot.demo01.web.controller;

import com.wx.springBoot.demo01.common.WrapMapper;
import com.wx.springBoot.demo01.common.Wrapper;
import com.wx.springBoot.demo01.model.pojo.Student;
import com.wx.springBoot.demo01.service.IStudentService;
import com.wx.springBoot.demo01.service.impl.StudentServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxin
 * @Title
 * @Description
 * @date 2019-10-29 11:27
 */
@RestController
public class StudentController {
    private static final Logger logger = LogManager.getLogger(StudentController.class);

    @Resource
    private IStudentService studentService;

    @GetMapping("/selectall")
    public Wrapper<List<Student>> selectAll(){
        logger.info("进入方法 selectAll");
        List<Student> students = studentService.studenetList();
        Wrapper<List<Student>> wrapper = null;
        if (null!=students){
            wrapper = WrapMapper.wrap(200,"查询成功",students);
        }else {
            wrapper = WrapMapper.wrap(200,"查无数据");
        }
        return wrapper;
    }
}
