package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StudentPayment;

public interface TuitionService {
	
	public boolean addTuition(StudentPayment studentPayment);

	public boolean updateTuition(StudentPayment studentPayment);

	public List<StudentPayment> FindTuitionForList(StudentPayment studentPayment);
	
}
