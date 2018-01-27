package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentOrder;

@Controller
@RequestMapping("/finance/tuition/")
public class TuitionController {
	
	@Resource(name="tuitionService")
	private TuitionService tuitionService;
	
	@RequestMapping("list.action")
	public String findTuitionForList(StudentPaymentOrder studentPaymentOrder,Model model) {
		List<StudentPaymentOrder> list =tuitionService.findTuitionForList(studentPaymentOrder);
        model.addAttribute("list", list);
        
        return "finance/tuition/Tuition_list";
	}
}
