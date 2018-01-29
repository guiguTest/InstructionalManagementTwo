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
		System.out.println(studentPaymentOrder);
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
	       return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	@RequestMapping("update.action")
	public String updateTuition(StudentPayment studentPayment,Model model) {
		boolean result=tuitionService.updateTuition(studentPayment);
		if(result) {
	           model.addAttribute("info","�޸ĳɹ�");
	       }else {
	           model.addAttribute("info","�޸�ʧ��");
	       }
	     return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
	@RequestMapping("load.action")
	public String loadTuition(Integer staffSalaryOrderId,Model model) {
		System.out.println(staffSalaryOrderId);
		StudentPayment studentPayment=tuitionService.findTuitionForId(staffSalaryOrderId);
		System.out.println(studentPayment);
		model.addAttribute("studentPayment",studentPayment);
		return "finance/tuition/Tuition_update";
	}
	
	
	@RequestMapping("delete.action")
	public String deleteTuition(Integer studentPaymentId,Model model) {
		boolean result=tuitionService.deleteTuition(studentPaymentId);
		if(result) {
	           model.addAttribute("info","ɾ���ɹ�");
	       }else {
	           model.addAttribute("info","ɾ��ʧ��");
	       }
	     return this.findTuitionForList(new StudentPaymentOrder(), model);
	}
}
