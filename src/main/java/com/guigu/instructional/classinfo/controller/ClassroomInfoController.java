package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.ClassroomInfoService;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.DisciplineInfo;

@Controller
@RequestMapping("/classinfo/classroominfo/")
public class ClassroomInfoController {

	@Resource(name="classroomInfoServiceImpl")
	private ClassroomInfoService classroomInfoService;
	
	@RequestMapping("add.action")
	public String addClassroomInfo(ClassroomInfo classroomInfo,Model model) {
		boolean result = classroomInfoService.addClassroomInfo(classroomInfo);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info", "���ʧ��");
		}
		
		return this.list(null,model);
	}

	@RequestMapping("list.action")
	public String list(ClassroomInfo classroomInfo, Model model) {
		List<ClassroomInfo> list = classroomInfoService.getClassroomInfoList(classroomInfo);
		model.addAttribute("list", list);
		
		return "/classinfo/classroominfo/classroominfo_list";
	}
	
	@RequestMapping("load.action")
	public String loadUpate(Integer classroomId, Model model) {
		ClassroomInfo classroomInfo = classroomInfoService.getClassroomInfo(classroomId);
		model.addAttribute("classroomInfo", classroomInfo);
		return "/classinfo/classroominfo/classroominfo_update";
	}

	@RequestMapping("update.action")
	public String updateClassroomInfo(ClassroomInfo classroomInfo, Model model) {
		boolean result = classroomInfoService.updateClassroomInfo(classroomInfo);
		if (result) {
			model.addAttribute("info", "�޸ĳɹ�");
		} else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.list(null, model);
	}

	@RequestMapping("delete.action")
    public String deleteClassroomInfo(ClassroomInfo classroomInfo,Model model) {
        
      
		classroomInfo.setClassroomMark("0");
        
        boolean result =classroomInfoService.updateClassroomInfo(classroomInfo);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }
}
