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
		
		model.addAttribute("list",list);
		return "student/student/student_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(StudentInfo studentInfo,Model model ) {
		boolean result=studentInfoService.addStudent(studentInfo);
		if(result) {
			model.addAttribute("info","���ӳɹ�");
			
		}else {
			model.addAttribute("info","����ʧ��");
		}
		
		return "student/student/student_add";
	} 
	
	@RequestMapping("load.action")
	public String load(Integer studentId,Model model ) {
		StudentInfo studentInfo=studentInfoService.getStudent(studentId);
		model.addAttribute("studentInfo",studentInfo);
		
		return "student/student/student_update";
	}
	
	
	@RequestMapping("update.action")
	public String update(StudentInfo studentInfo,Model model ) {
		
		boolean result=studentInfoService.updateStudent(studentInfo);
		if(result) {
			model.addAttribute("info", "�޸ĳɹ�");
			
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		
		 return this.list(null,model);
	}
	
	@RequestMapping("delete.action")
	public String delete(StudentInfo studentInfo,Model model ) {
		studentInfo.setStudentMark(0);
		boolean result=studentInfoService.updateStudent(studentInfo);
		
		if(result) {
			model.addAttribute("info", "ɾ���ɹ�");
		}else {
			model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.list(null,model);
	}
}
