package com.guigu.instructional.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoClassInfoStaffInfo;
import com.guigu.instructional.student.mapper.StudentInfoClassInfoStaffInfoMapper;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.StudentInfoService;

@Service("studentInfoServiceImpl")
public class StudentInfoServiceImpl implements StudentInfoService {

	@Resource(name="studentInfoClassInfoStaffInfoMapper")
	private StudentInfoClassInfoStaffInfoMapper studentInfoClassInfoStaffInfoMapper;
	
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	@Override
	public List<StudentInfoClassInfoStaffInfo> findStudentList() {
		
		return studentInfoClassInfoStaffInfoMapper.findStudentList();
	}


	@Override
	public boolean addStudent(StudentInfo studentInfo) {
		int i=studentInfoMapper.insertSelective(studentInfo);
		
		if(i>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean updateStudent(StudentInfo studentInfo) {
		return false;
	}


	@Override
	public StudentInfo getStudent(Integer studentId) {
		return null;
	}

}
