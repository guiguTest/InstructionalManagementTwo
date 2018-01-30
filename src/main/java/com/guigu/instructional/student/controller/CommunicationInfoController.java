package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoStudentInfoStaffInfo;
import com.guigu.instructional.student.service.CommunicationInfoService;

@Controller
@RequestMapping("student/communicateinfo")
public class CommunicationInfoController {

	@Resource(name="communicationInfoService")
	private CommunicationInfoService communicationInfoService;
	
	
	@RequestMapping("list.action")
	public String list(CommunicationInfoStudentInfoStaffInfo communicationInfoStudentInfoStaffInfo,Model model) {
		List<CommunicationInfoStudentInfoStaffInfo> list=communicationInfoService.findCommunication();
		
		model.addAttribute("list",list);
		
		return "student/communicateinfo/communicateinfo_list";
	}
	
	@RequestMapping("add.action")
	public String add(CommunicationInfo communicationInfo,Model model) {
		boolean result=communicationInfoService.addCommunication(communicationInfo);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
			
		
		return this.list(null, model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer communicationId,Model model) {
		CommunicationInfo communicationInfo=communicationInfoService.getCommunicationInfo(communicationId);
		 
		model.addAttribute("communicationInfo",communicationInfo);
		return "student/communicateinfo/communicateinfo_update";
	}
	
	@RequestMapping("update.action")
	public String update(CommunicationInfo communicationInfo,Model model) {
		boolean result=communicationInfoService.updateCommunication(communicationInfo);
		if(result) {
			model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
			
		
		return this.list(null, model);
	}
	@RequestMapping("delete.action")
	public String delete(Integer communicationId,Model model) {
		boolean result=communicationInfoService.deleteCommunication(communicationId);
		 
		if(result) {
			model.addAttribute("info", "删除成功");
		}else {
			model.addAttribute("info", "删除失败");
		}
		return this.list(null, model);
	}
	
}
