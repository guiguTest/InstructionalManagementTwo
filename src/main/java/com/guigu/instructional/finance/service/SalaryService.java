package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StaffSalary;

//用于实现员工工资的service
public interface SalaryService {

	public boolean addSalary(StaffSalary staffSalary) ;
	
	public boolean updateSalary(StaffSalary staffSalary);
	
	public List<StaffSalary> findSalaryForList(StaffSalary staffSalary);
}
