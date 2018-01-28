package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.finance.service.impl.TuitionServiceImpl;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentOrder;

@Controller
@RequestMapping("/finance/tuition")
public class TuitionController {
	
	@Resource(name="tuitionServiceImpl")
	private TuitionService tuitionService;
	
	@RequestMapping("list.action")
	public String findTuitionForList(StudentPaymentOrder studentPaymentOrder,Model model) {
		List<StudentPaymentOrder> list =tuitionService.findTuitionForList(studentPaymentOrder);
        model.addAttribute("list", list);
        
        return "finance/tuition/Tuition_list";
	}
	@RequestMapping("show.action")
	public String showTuition(Integer studentPaymentId,Model model){
		StudentPayment studentPayment=tuitionService.findTuitionForId(studentPaymentId);
		model.addAttribute("studentPayment", studentPayment);
        return "finance/tuition/Tuition_show";
	}
	@RequestMapping("add.action")
	public String addTuition(StudentPayment studentPayment,Model model){
		boolean result=tuitionService.addTuition(studentPayment);
		if(result) {
	           model.addAttribute("info","��ӳɹ�");
	       }else {
	           model.addAttribute("info","���ʧ��");
	       }
	       return this.findTuitionForList(null, model);
	}
	
	
}
