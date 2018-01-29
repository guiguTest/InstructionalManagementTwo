package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StaffSalaryOrder;

//用于实现员工工资的service
public interface SalaryService {

	public boolean addSalary(StaffSalary staffSalary) ;
	
	public boolean updateSalary(StaffSalary staffSalary);
	
	public List<StaffSalaryOrder> findSalaryForList(StaffSalaryOrder staffSalaryOrder);
	
	public StaffSalaryOrder findSalaryById(Integer staffSalaryId);
}
