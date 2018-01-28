package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.SyllabusInfo;


@Controller
@RequestMapping("/classinfo/disciplineinfo/")
public class DisciplineInfoController {
	
	@Resource(name="DisciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	@RequestMapping("add.action")
	public String addDisciplineInfo(DisciplineInfo disciplineInfo,Model model) {
		boolean result = disciplineInfoService.addRole(disciplineInfo);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info", "���ʧ��");
		}
		
		return this.list(null,model);
	}

	@RequestMapping("list.action")
	public String list(DisciplineInfo disciplineInfo, Model model) {
		List<DisciplineInfo> list = disciplineInfoService.getDisciplineInfoList(disciplineInfo);
		model.addAttribute("list", list);
		
		return "classinfo/disciplineinfo/disciplineinfo_list";
	}
	
	@RequestMapping("load.action")
	public String loadUpate(Integer disciplineId, Model model) {
		DisciplineInfo disciplineInfo = disciplineInfoService.getDisciplineInfo(disciplineId);
		model.addAttribute("disciplineInfo", disciplineInfo);
		return "classinfo/disciplineinfo/disciplineinfo_update";
	}

	@RequestMapping("update.action")
	public String updateDisciplineInfo(DisciplineInfo disciplineInfo, Model model) {
		boolean result = disciplineInfoService.updateRole(disciplineInfo);
		if (result) {
			model.addAttribute("info", "�޸ĳɹ�");
		} else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.list(null, model);
	}

	@RequestMapping("delete.action")
    public String deleteDisciplineInfo(DisciplineInfo disciplineInfo,Model model) {
        
      
		disciplineInfo.setDisciplineIsused("0");
        
        boolean result =disciplineInfoService.updateRole(disciplineInfo);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }
	
}
