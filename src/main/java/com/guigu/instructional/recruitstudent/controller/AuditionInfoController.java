package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.RoleInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.student.service.StudentInfoService;
import com.lowagie.tools.split_pdf;

@Controller
@RequestMapping("/recruitstudent/auditionInfo")
public class AuditionInfoController {
	
	@Resource(name="auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name="disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	@RequestMapping("loadAdd.action")
	public String loadAdd(Model model) {
		
		List<StudentInfo> slist=studentInfoService.getStudentNameList(null);
		model.addAttribute("studentlist", slist);
		
		List<DisciplineInfo> dlist=disciplineInfoService.getDisciplineNameList(null);
		model.addAttribute("disciplinelist", dlist);
		
		return "recruitstudent/auditioninfo/auditioninfo_add";
	}
	
	@RequestMapping("add.action")
	public String addAuditionInfo(AuditionInfo auditionInfo,Model model) {
		
		//添加试听记录
		boolean result =auditionInfoService.addAudition(auditionInfo);
		
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
		return this.list(null,model);
	}
	
	@RequestMapping("delete.action")
    public String delete(Integer auditionId,Model model) {
        
        int reuslt = auditionInfoService.deleteAuditionInfo(auditionId);
        if(reuslt>0) {
            model.addAttribute("info", "删除成功");
        }else {
            model.addAttribute("info", "删除失败");
        }
        return this.list(null, model);
    }
	
	@RequestMapping("loadUpdate.action")
	public String loadUpdate(Integer auditionId,Model model) {
		
		AuditionInfo auditionInfo=auditionInfoService.getAuditionInfo(auditionId);
		model.addAttribute("auditionInfo", auditionInfo);
		
		List<StudentInfo> slist=studentInfoService.getStudentNameList(null);
		model.addAttribute("studentlist", slist);
		
		List<DisciplineInfo> dlist=disciplineInfoService.getDisciplineNameList(null);
		model.addAttribute("disciplinelist", dlist);
		
		return "recruitstudent/auditioninfo/auditioninfo_update";
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
		return "recruitstudent/auditioninfo/auditioninfo_list";
	}
	
}
