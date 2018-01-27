package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.mapper.StudentPaymentMapper;
import com.guigu.instructional.finance.mapper.StudentPaymentOrderMapper;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentExample;
import com.guigu.instructional.po.StudentPaymentOrder;
@Service("tuitionServiceImpl")
public abstract class TuitionServiceImpl implements TuitionService{

	@Resource(name="StudentPaymentMapper")
	private StudentPaymentMapper StudentPaymentMapper;
	@Resource(name="StudentPaymentOrderMapper")
	private StudentPaymentOrderMapper StudentPaymentOrderMapper;
	@Override
	public boolean addTuition(StudentPayment studentPayment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTuition(StudentPayment studentPayment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentPaymentOrder> findTuitionForList(StudentPaymentOrder studentPaymentOrder) {
		return StudentPaymentOrderMapper.findStudentPaymentOrder(studentPaymentOrder);
	}
}
