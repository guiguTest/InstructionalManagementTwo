package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.mapper.StudentPaymentMapper;
import com.guigu.instructional.finance.service.TuitionService;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentExample;
@Service("tuitionServiceImpl")
public class TuitionServiceImpl implements TuitionService{

	@Resource(name="StudentPaymentMapper")
	private StudentPaymentMapper StudentPaymentMapper;
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
	public List<StudentPayment> FindTuitionForList(StudentPayment studentPayment) {
		StudentPaymentExample studentPaymentExample=new StudentPaymentExample();
		if(studentPayment!=null) {
			if(studentPayment.getPaymentId()!=null) {
				
			}else if(studentPayment.getPaymentTime()!=null) {
				
			}
		}
		return null;
	}
	
}
