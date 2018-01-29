package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StaffSalaryOrder;
import com.guigu.instructional.po.StudentPaymentOrder;

@Controller
@RequestMapping("/finance/salary")
public class SalaryController {
	
	@Resource(name="salaryServiceImpl")
	private SalaryService salaryService;
	
	@RequestMapping("list.action")
	public String findSalaryForList(StaffSalaryOrder staffSalaryOrder,Model model) {
        List<StaffSalaryOrder> list=salaryService.findSalaryForList(staffSalaryOrder);
        model.addAttribute("list", list);
        return "finance/salary/Salary_list";
	}
	
	@RequestMapping("add.action")
	public String addSalary(StaffSalary staffSalary,Model model) {
		boolean result=salaryService.addSalary(staffSalary);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.findSalaryForList(null, model);
	}
	
	
}
