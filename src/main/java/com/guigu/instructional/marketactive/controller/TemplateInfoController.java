package com.guigu.instructional.marketactive.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.TemplateInfo;


@Controller
@RequestMapping("/marketactive/template/")
public class TemplateInfoController {
	@Resource(name="templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;
	
	@RequestMapping("add.action")
    public String addTemplate(TemplateInfo templateInfo,Model model) {
       boolean result= templateInfoService.addTemplate(templateInfo);
       if(result) {
           model.addAttribute("info","��ӳɹ�");
       }else {
           model.addAttribute("info","���ʧ��");
       }
       return this.list(null, model);
       
    }
    
    @RequestMapping("list.action")
    public String list(TemplateInfo templateInfo,Model model) {
        List<TemplateInfo> list =templateInfoService.getTemplateInfoList(templateInfo);
        model.addAttribute("list", list);
        return "marketactive/template/template_list";
    }
    @RequestMapping("load.action")
    public String loadUpate(Integer templateId,Model model) {
    	TemplateInfo templateInfo=templateInfoService.getTemplateInfo(templateId);
        model.addAttribute("templateInfo", templateInfo);
        return "marketactive/template/template_update";
    }
    
    @RequestMapping("update.action")
    public String update(TemplateInfo templateInfo,Model model) {
        boolean result=templateInfoService.updateTemplate(templateInfo);
        if(result) {
            model.addAttribute("info", "�޸ĳɹ�");
        }else {
            model.addAttribute("info", "�޸�ʧ��");
        }
        return this.list(null, model);
    }
    
    @RequestMapping("delete.action")
    public String delete(Integer templateId,Model model) {
        
        boolean result =templateInfoService.deleteTemplate(templateId);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }

}
