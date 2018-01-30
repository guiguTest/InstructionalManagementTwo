package com.guigu.instructional.marketactive.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.EmailService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailVO;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.StaffInfoService;


@Controller
@RequestMapping("/marketactive/emailinfo/")
public class EmailController {
	@Resource(name="emailServiceImpl")
	private EmailService emailService; 
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("list.action")
	public String emailList(EmailInfo emailInfo,Model model) {
		List<EmailInfo> list=emailService.getEmailStaff(emailInfo);
		model.addAttribute("list", list);
		return "/marketactive/emailinfo/emailinfo_list";
	}
	
	@RequestMapping("add.action")
	public String addEmail(EmailVO emailVO,Model model) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(emailVO.getStaffName());
		if(staffInfo!=null) {
			emailVO.setStaffId(staffInfo.getStaffId());
		}else {
			emailVO.setStaffId(null);
		}
		emailVO.setEmailTime(new Date());
		emailVO.setEmailState("已发送");
		boolean flag=emailService.addEmail(emailVO);
		if(flag) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
		
		return this.emailList(null,model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer emailId,Model model) {
		EmailVO emailVO =emailService.findEmailById(emailId);
		model.addAttribute("email", emailVO);
		return "marketactive/emailinfo/emailinfo_update";
	}
	
	@RequestMapping("update.action")
	public String update(EmailVO emailVO,Model model) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(emailVO.getStaffName());
		if(staffInfo!=null) {
			emailVO.setStaffId(staffInfo.getStaffId());
		}else{
			emailVO.setStaffId(null);
		}
		boolean flag=emailService.updateEmail(emailVO);
		if(flag) {
			model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		
		return this.emailList(null,model);
	}
	@RequestMapping("delete.action")
	public String deleteEmail(EmailInfo emailInfo,Model model) {
		boolean flag=emailService.deleteEmail(emailInfo.getEmailId());
		if(flag) {
			model.addAttribute("info", "刪除成功");
		}else {
			model.addAttribute("info", "刪除失败");
		}
		return this.emailList(null,model);
	}

}
