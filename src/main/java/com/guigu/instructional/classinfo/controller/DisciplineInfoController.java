package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.DisciplineInfo;


@Controller
@RequestMapping("/classinfo/disciplineinfo/")
public class DisciplineInfoController {
	
	@Resource(name="DisciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	@RequestMapping("add.action")
	public String addDisciplineInfo(DisciplineInfo disciplineInfo,Model model) {
		boolean result = disciplineInfoService.addRole(disciplineInfo);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
		
		return this.list(null,model);
	}

	@RequestMapping("list.action")
	public String list(DisciplineInfo disciplineInfo, Model model) {
		List<DisciplineInfo> list = disciplineInfoService.getDisciplineInfoList(disciplineInfo);
		model.addAttribute("list", list);
		
		return "classinfo/disciplineinfo/disciplineinfo_list";
	}
	
}
