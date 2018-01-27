package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.student.service.EvaluationInfoService;

@Controller
@RequestMapping("/student/evaluationinfo")
public class EvaluationInfoController {

	
	@Resource(name="evaluationInfoServiceImpl")
	private EvaluationInfoService evaluationInfoService;
	
	
	@RequestMapping("list.action")
	public String list(EvaluationInfo evaluationInfo,Model model) {
		List<EvaluationInfo> list=evaluationInfoService.getEvaluationInfoList(evaluationInfo);
		model.addAttribute("list",list);
		return "student/evaluationinfo/evaluationinfo_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(EvaluationInfo evaluationInfo,Model model) {
		boolean result=evaluationInfoService.addEvaluation(evaluationInfo);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.list(null, model);
	}
	
	
}
