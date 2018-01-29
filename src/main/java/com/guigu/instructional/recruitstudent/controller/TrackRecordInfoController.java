package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.recruitstudent.service.TrackRecordInfoService;
import com.guigu.instructional.student.service.StudentInfoService;

@Controller
@RequestMapping("/recruitstudent/trackrecord")
public class TrackRecordInfoController {
	
	@Resource(name="trackRecordInfoServiceImpl")
	private TrackRecordInfoService trackRecordInfoService;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@RequestMapping("loadAdd.action")
	public String loadAdd(Model model) {

		List<StudentInfo> slist = studentInfoService.getStudentInfoPoolList(null);
		model.addAttribute("studentlist", slist);

		return "recruitstudent/trackrecord/trackrecord_add";
	}

	@RequestMapping("add.action")
	public String addTrackRecordInfo(TrackRecordInfo trackRecordInfo, Model model) throws Exception{

		// ���������¼
		boolean result = trackRecordInfoService.addTrackRecord(trackRecordInfo);
		if (result) {
			model.addAttribute("info", "��ӳɹ�");
		} else {
			model.addAttribute("info", "���ʧ��");
		}
		return this.list(null, model);
	}

	@RequestMapping("delete.action")
	public String delete(Integer trackRecordId, Model model) throws Exception{
		int reuslt = trackRecordInfoService.deleteTrackRecordInfo(trackRecordId);
		if (reuslt > 0) {
			model.addAttribute("info", "ɾ���ɹ�");
		} else {
			model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.list(null, model);
	}

	@RequestMapping("loadUpdate.action")
	public String loadUpdate(Integer trackRecordId, Model model) {

		TrackRecordInfo trackRecordInfo = trackRecordInfoService.getTrackRecordInfo(trackRecordId);
		model.addAttribute("trackRecordInfo", trackRecordInfo);

		List<StudentInfo> slist = studentInfoService.getStudentInfoPoolList(null);
		model.addAttribute("studentlist", slist);

		return "recruitstudent/trackrecord/trackrecord_update";
	}

	@RequestMapping("update.action")
	public String updateTrackRecordInfo(TrackRecordInfo trackRecordInfo, Model model) throws Exception{
		boolean result = trackRecordInfoService.upadteTrackRecord(trackRecordInfo);

		if (result) {
			model.addAttribute("info", "�޸ĳɹ�");
		} else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.list(null, model);
	}

	@RequestMapping("list.action")
	public String list(StudentInfo studentInfo, Model model) throws Exception{
		List<TrackRecordCustom> list = trackRecordInfoService.getTrackRecordCustomList(studentInfo);
		model.addAttribute("list", list);
		return "recruitstudent/trackrecord/trackrecord_list";
	}

}
