package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoStudentInfo;
import com.guigu.instructional.student.service.EvaluationInfoService;

@Controller
@RequestMapping("/student/evaluationinfo")
public class EvaluationInfoController {

	
	@Resource(name="evaluationInfoServiceImpl")
	private EvaluationInfoService evaluationInfoService;
	
	
	@RequestMapping("list.action")
	public String list(EvaluationInfoStudentInfo evaluationInfoStudentInfo,Model model) {
		List<EvaluationInfoStudentInfo> list=evaluationInfoService.findEvaluationList();
		model.addAttribute("list",list);
		return "student/evaluationinfo/evaluationinfo_list";
	}
	
	
	@RequestMapping("add.action")
	public String add(EvaluationInfo evaluationInfo,Model model) {
		boolean result=evaluationInfoService.addEvaluation(evaluationInfo);
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.list(null, model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer evaluationId,Model model) {
		EvaluationInfo evaluationInfo=evaluationInfoService.getEvaluationInfo(evaluationId);
		
		model.addAttribute("evaluationInfo",evaluationInfo);
		
		
		return"student/evaluationinfo/evaluationinfo_update";
	}
	
	@RequestMapping("update.action")
	public String update(EvaluationInfo evaluationInfo,Model model) {
		boolean result=evaluationInfoService.updateEvaluation(evaluationInfo);
		
		if(result) {
			model.addAttribute("info","���³ɹ�");
		}else {
			model.addAttribute("info","����ʧ��");
		}
		return this.list(null,model);
	}
	
	@RequestMapping("delete.action")
	public String delete(Integer evaluationId,Model model) {
	  boolean result=evaluationInfoService.deleteEvaluationInfo(evaluationId);
	  if(result) {
		  model.addAttribute("info","ɾ���ɹ�");
		  
	  }else {
	  model.addAttribute("info","ɾ��ʧ��");
	  }
	  return this.list(null, model);
	}
}
