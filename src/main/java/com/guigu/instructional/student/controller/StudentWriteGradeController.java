package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.po.StudentWriteGradeStudentInfoStaffInfo;
import com.guigu.instructional.student.service.StudentWriteGradeService;

@Controller
@RequestMapping("/student/studentwritegrade")
public class StudentWriteGradeController {

	@Resource(name="studentWriteGradeServiceImpl")
	private StudentWriteGradeService studentWriteGradeService;
	
	
	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,Model model) {
		List<StudentWriteGradeCustom> list=studentWriteGradeService.getStudentWriteGradeList(studentInfo);
		model.addAttribute("list",list);
		
		return "student/studentwritegrade/studentwritegrade_list";
	}
	
	@RequestMapping("add.action")
	public String add(StudentWriteGrade studentWriteGrade,Model model) {
		boolean result=studentWriteGradeService.addStudentWriteGrade(studentWriteGrade);
		
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		
		return this.list(null, model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer writeGradeId,Model model) {
		StudentWriteGrade studentWriteGrade=studentWriteGradeService.getStudentWriteGrade(writeGradeId);
		
		model.addAttribute("studentWriteGrade", studentWriteGrade);
		
		return "student/studentwritegrade/studentwritegrade_update";
	}
	
	@RequestMapping("update.action")
	public String update(StudentWriteGrade studentWriteGrade,Model model) {
		boolean result=studentWriteGradeService.updateStudentWriteGrade(studentWriteGrade);
		
		if(result) {
			model.addAttribute("info","�޸ĳɹ�");
		}else {
			model.addAttribute("info","�޸�ʧ��");
		}
		
		return this.list(null, model);
	}
	
	@RequestMapping("delete.action")
	public String delete(Integer writeGradeId,Model model) {
		boolean result=studentWriteGradeService.deleteStudentWriteGrade(writeGradeId);
		
		if(result) {
			model.addAttribute("info","ɾ���ɹ�");
		}else {
			model.addAttribute("info","ɾ��ʧ��");
		}
		
		return this.list(null, model);
	}
}
