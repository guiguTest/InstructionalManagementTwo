package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentCustom;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/recruitstudent/studentpool")
public class StudentInfoPoolController {

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo, Model model) {
		List<StudentCustom> list = studentInfoService.getStudentCustomList(studentInfo);
		model.addAttribute("list", list);
		return "recruitstudent/studentpool/studentpool_list";
	}

	@RequestMapping("loadAdd.action")
	public String loadAdd(Model model) {

		List<StaffInfo> slist = staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist", slist);

		return "recruitstudent/studentpool/studentpool_add";
	}

	@RequestMapping("add.action")
	public String addStudentInfo(StudentInfo studentInfo, Model model) {
		// 0为学生池的学生 1为正式学生
		studentInfo.setStudentMark(0);
		// 添加试听记录
		boolean result = studentInfoService.addStudentInfo(studentInfo);

		if (result) {
			model.addAttribute("info", "添加成功");
		} else {
			model.addAttribute("info", "添加失败");
		}
		return this.list(null, model);
	}

	@RequestMapping("loadUpdate.action")
	public String loadUpdate(Integer studentId, Model model) {

		StudentInfo studentInfo = studentInfoService.getStudentInfo(studentId);
		System.out.println(studentInfo);
		model.addAttribute("studentInfo", studentInfo);

		List<StaffInfo> slist = staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist", slist);

		return "recruitstudent/studentpool/studentpool_update";
	}

	@RequestMapping("update.action")
	public String updateStudentInfo(StudentInfo studentInfo, Model model) {
		// 0为学生池的学生 1为正式学生
		studentInfo.setStudentMark(0);
		// 修改试听记录
		boolean result = studentInfoService.upadteStudentInfo(studentInfo);

		if (result) {
			model.addAttribute("info", "修改成功");
		} else {
			model.addAttribute("info", "修改失败");
		}
		return this.list(null, model);
	}
	
	@RequestMapping("updateMark.action")
	public String updateMark(Integer studentId, Model model) {
		StudentInfo studentInfo=studentInfoService.getStudentInfo(studentId);
		// 0为学生池的学生 1为正式学生
		studentInfo.setStudentMark(1);
		boolean result = studentInfoService.upadteStudentInfo(studentInfo);

		if (result) {
			model.addAttribute("info", "领取学生成功");
		} else {
			model.addAttribute("info", "领取学生失败");
		}
		return this.list(null, model);
	}


	@RequestMapping("delete.action")
	public String delete(Integer studentId, Model model) {

		int reuslt = studentInfoService.deleteStudentInfo(studentId);
		if (reuslt > 0) {
			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}

}
