package com.guigu.instructional.student2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoCustom;
import com.guigu.instructional.student2.service.StudentInfo2Service;

@Controller
@RequestMapping("/student/student")
public class StudentInfoController {

	@Resource(name="studentInfoService")
	private StudentInfo2Service studentInfoService;
	
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		List<StudentInfoCustom> list=studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("list",list);
		return "student/student/student_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(@Validated StudentInfo studentInfo,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("studentInfo",studentInfo);
			
			return "student/student/student_add";
		}else {
		
		boolean result=studentInfoService.addStudent(studentInfo);
		if(result) {
			model.addAttribute("info","���ӳɹ�");
			
		}else {
			model.addAttribute("info","����ʧ��");
		}
		
		return this.list(null,model);
		}
	} 
	
	@RequestMapping("load.action")
	public String load(Integer studentId,Model model ) {
		StudentInfo studentInfo=studentInfoService.getStudent(studentId);
		model.addAttribute("studentInfo",studentInfo);
		
		return "student/student/student_update";
	}
	
	
	@RequestMapping("update.action")
	public String update(@Validated StudentInfo studentInfo,BindingResult bindingResult,Model model ) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			model.addAttribute("allErrors",allErrors);
			
			model.addAttribute("studentInfo",studentInfo);
			
			return "student/student/student_update";
		}else {
		boolean result=studentInfoService.updateStudent(studentInfo);
		if(result) {
			model.addAttribute("info", "�޸ĳɹ�");
			
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		
		 return this.list(null,model);
		}
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
