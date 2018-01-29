package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;

@Controller
@RequestMapping("/recruitstudent/auditionInfo")
public class AuditionInfoController {
	
	@Resource(name="auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;
	
	
	@RequestMapping("add.action")
	public String addAuditionInfo(AuditionInfo auditionInfo,Model model) {
		boolean result =auditionInfoService.addAudition(auditionInfo);
		
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
		return this.list(null,model);
	}
	
	@RequestMapping("update.action")
	public String updateAuditionInfo(AuditionInfo auditionInfo,Model model) {
		boolean result =auditionInfoService.upadteAudition(auditionInfo);
		
		if(result) {
			model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.list(null,model);
	}
	
	@RequestMapping("list.action")
	public String list(AuditionInfo auditionInfo,Model model) {
		
		List<AuditionInfo> list=auditionInfoService.getAuditionInfoList(auditionInfo);
		model.addAttribute("list", list);
		
		return "recruitstudent/auditionInfo/auditionInfo_list";
	}
	
//	@RequestMapping("show.action")
//	public String showAuditionInfo(Integer auditionId,Model model) {
//		AuditionInfo auditionInfo=auditionInfoService.getAuditionInfo(auditionId);
//		model.addAttribute("auditionInfo", auditionInfo);
//		return "recruitstudent/auditionInfo/auditionInfo_show";
//	}
	
	
	
}
