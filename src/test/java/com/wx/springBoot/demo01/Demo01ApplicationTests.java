package com.wx.springBoot.demo01;

import com.wx.springBoot.demo01.model.pojo.Student;
import com.wx.springBoot.demo01.service.IStudentService;
import com.wx.springBoot.demo01.web.controller.StudentController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01ApplicationTests {
	private static final Logger logger = LogManager.getLogger(Demo01ApplicationTests.class);

	@Autowired
	private IStudentService studentService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() throws Exception {
		Student student1 = studentService.queryStudentBySno("001");
		logger.info("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

		Student student2 = studentService.queryStudentBySno("001");
		logger.info("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
	}
}
