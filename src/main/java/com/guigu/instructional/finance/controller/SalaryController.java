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
			model.addAttribute("info","���ӳɹ�");
		}else {
			model.addAttribute("info","����ʧ��");
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
	public String updateSalary(StaffSalary staffSalary,Model model) {
		boolean result=salaryService.updateSalary(staffSalary);
		if(result) {
			model.addAttribute("info","�޸ĳɹ�");
		}else {
			model.addAttribute("info","�޸�ʧ��");
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
			model.addAttribute("info","ɾ���ɹ�");
		}else {
			model.addAttribute("info","ɾ��ʧ��");
		}
		return this.findSalaryForList(new StaffSalaryOrder(), model);
	}
}
