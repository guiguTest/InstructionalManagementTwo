package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.finance.mapper.StaffSalaryMapper;
import com.guigu.instructional.finance.mapper.StaffSalaryOrderMapper;
import com.guigu.instructional.finance.service.SalaryService;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StaffSalaryOrder;

@Service("salaryServiceImpl")
public class SalaryServiceImpl implements SalaryService{
	
	@Resource(name="staffSalaryMapper")
	private StaffSalaryMapper staffSalaryMapper;
	@Resource(name="staffSalaryOrderMapper")
	private StaffSalaryOrderMapper staffSalaryOrderMapper;
	@Override
	public boolean addSalary(StaffSalary staffSalary) {
		return false;
	}

	@Override
	public boolean updateSalary(StaffSalary staffSalary) {
		return false;
	}

	@Override
	public List<StaffSalaryOrder> findSalaryForList(StaffSalaryOrder staffSalaryOrder) {
		return staffSalaryOrderMapper.findStudentPaymentOrder(staffSalaryOrder);
	}

	@Override
	public StaffSalaryOrder findSalaryById(Integer staffSalaryId){
		return staffSalaryOrderMapper.findStudentPaymentOrderById(staffSalaryId);
	}

}
