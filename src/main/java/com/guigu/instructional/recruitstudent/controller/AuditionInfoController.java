package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Controller
@RequestMapping("/recruitstudent/auditionInfo")
public class AuditionInfoController {

	@Resource(name = "auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;

	@RequestMapping("loadAdd.action")
	public String loadAdd(Model model) {

		List<StudentInfo> slist = studentInfoService.getStudentInfoPoolList(null);
		model.addAttribute("studentlist", slist);

		List<DisciplineInfo> dlist = disciplineInfoService.getDisciplinePoolList(null);
		model.addAttribute("disciplinelist", dlist);

		return "recruitstudent/auditioninfo/auditioninfo_add";
	}

	@RequestMapping("add.action")
	public String addAuditionInfo(AuditionInfo auditionInfo, Model model) throws Exception{

		// ���������¼
		boolean result = auditionInfoService.addAudition(auditionInfo);

		if (result) {
			model.addAttribute("info", "��ӳɹ�");
		} else {
			model.addAttribute("info", "���ʧ��");
		}
		return this.list(null,null, model);
	}

	@RequestMapping("delete.action")
	public String delete(Integer auditionId, Model model) throws Exception{

		int reuslt = auditionInfoService.deleteAuditionInfo(auditionId);
		if (reuslt > 0) {
			model.addAttribute("info", "ɾ���ɹ�");
		} else {
			model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.list(null,null, model);
	}

	@RequestMapping("loadUpdate.action")
	public String loadUpdate(Integer auditionId, Model model) {

		AuditionInfo auditionInfo = auditionInfoService.getAuditionInfo(auditionId);
		model.addAttribute("auditionInfo", auditionInfo);

		List<StudentInfo> slist = studentInfoService.getStudentInfoPoolList(null);
		model.addAttribute("studentlist", slist);

		List<DisciplineInfo> dlist = disciplineInfoService.getDisciplinePoolList(null);
		model.addAttribute("disciplinelist", dlist);

		return "recruitstudent/auditioninfo/auditioninfo_update";
	}

	@RequestMapping("update.action")
	public String updateAuditionInfo(AuditionInfo auditionInfo, Model model) throws Exception{
		boolean result = auditionInfoService.upadteAudition(auditionInfo);

		if (result) {
			model.addAttribute("info", "�޸ĳɹ�");
		} else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.list(null,null, model);
	}

	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo,DisciplineInfo disciplineInfo, Model model) throws Exception{
		List<AuditionCustom> list = auditionInfoService.getAuditionCustomList(studentInfo, disciplineInfo);
		model.addAttribute("list", list);
		return "recruitstudent/auditioninfo/auditioninfo_list";
	}

}
