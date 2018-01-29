package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoClassInfoStaffInfo;
import com.guigu.instructional.student.service.StudentInfoService;

@Controller
@RequestMapping("/student/student")
public class StudentInfoController {

	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	
	@RequestMapping("list.action")
	public String list(StudentInfoClassInfoStaffInfo studentInfoClassInfoStaffInfo,Model model) {
		List<StudentInfoClassInfoStaffInfo> list=studentInfoService.findStudentList();
		System.out.println(list);
		model.addAttribute("list",list);
		return "student/student/student_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(StudentInfo studentInfo,Model model ) {
		boolean result=studentInfoService.addStudent(studentInfo);
		if(result) {
			model.addAttribute("info","增加成功");
			
		}else {
			model.addAttribute("info","增加失败");
		}
		
		return "student/student/student_add";
	} 
}
