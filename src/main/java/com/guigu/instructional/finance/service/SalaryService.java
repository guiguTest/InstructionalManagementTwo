package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StaffSalary;

//����ʵ��Ա�����ʵ�service
public interface SalaryService {

	public boolean addSalary(StaffSalary staffSalary) ;
	
	public boolean updateSalary(StaffSalary staffSalary);
	
	public List<StaffSalary> findSalaryForList(StaffSalary staffSalary);
}
