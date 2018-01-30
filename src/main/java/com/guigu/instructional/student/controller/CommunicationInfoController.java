package com.guigu.instructional.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.CommunicationInfo;

@Controller
@RequestMapping("student/communicateinfo")
public class CommunicationInfoController {

	
	@RequestMapping("list.action")
	public String list(CommunicationInfo communicationInfo,Model model) {
		
		return "student/communicateinfo/communicateinfo_list";
	}
}
