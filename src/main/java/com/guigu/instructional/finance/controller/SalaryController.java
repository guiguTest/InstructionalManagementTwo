package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
	public String addSalary(Model model,@Validated StaffSalary staffSalary,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> Errors=bindingResult.getAllErrors();
			for (ObjectError objectError : Errors) {
				System.out.println(objectError);
			}
			model.addAttribute("Errors",Errors);
			return "finance/salary/Salary_add";
		}
		boolean result=salaryService.addSalary(staffSalary);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.findSalaryForList(new StaffSalaryOrder(), model);
	}
	@RequestMapping("load.action")
	public String findStaffSalary(Integer staffSalaryOrderId,Model model) {
		StaffSalary staffSalary=salaryService.findSalaryById(staffSalaryOrderId);
		model.addAttribute("staffSalary", staffSalary);
		return "finance/salary/Salary_update";
	}
	@RequestMapping("update.action")
	public String updateSalary(Model model,@Validated StaffSalary staffSalary,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> Errors=bindingResult.getAllErrors();
			for (ObjectError objectError : Errors) {
				System.out.println(objectError);
			}
			model.addAttribute("Errors",Errors);
			return "finance/salary/Salary_update";
		}
		boolean result=salaryService.updateSalary(staffSalary);
		if(result) {
			model.addAttribute("info","修改成功");
		}else {
			model.addAttribute("info","修改失败");
		}
		return this.findSalaryForList(new StaffSalaryOrder(), model);
	}
	@RequestMapping("show.action")
	public String findSalaryOrder(Integer staffSalaryOrderId,Model model) {
		StaffSalaryOrder staffSalaryOrder=salaryService.findSalaryOrderById(staffSalaryOrderId);
		System.out.println(staffSalaryOrder);
		model.addAttribute("staffSalaryOrder", staffSalaryOrder);
		return "finance/salary/Salary_show";
	}
	@RequestMapping("delete.action")
	public String deleteSalary(Integer staffSalaryOrderId,Model model) {
		boolean result=salaryService.deleteSalary(staffSalaryOrderId);
		if(result) {
			model.addAttribute("info","删除成功");
		}else {
			model.addAttribute("info","删除失败");
		}
		return this.findSalaryForList(new StaffSalaryOrder(), model);
	}
}
