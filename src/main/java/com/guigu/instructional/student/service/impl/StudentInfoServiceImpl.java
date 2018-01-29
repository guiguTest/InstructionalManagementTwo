package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.AuditionStudentDisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.po.StudentInfoExample.Criterion;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.StudentInfoService;

@Service(value="studentInfoServiceImpl")
public class StudentInfoServiceImpl implements StudentInfoService{
	
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;

	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public List<StudentInfo> getStudentNameList(StudentInfo studentInfo) {
		
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();

		criteria.andStudentMarkEqualTo(0);
		return studentInfoMapper.selectByExample(studentInfoExample);
	}
	
	@Override
	public boolean addStudentInfo(StudentInfo studentInfo) {
		
		try {
			int i=studentInfoMapper.insertSelective(studentInfo);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean upadteStudentInfo(StudentInfo studentInfo) {
		try {
			int i=studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public int deleteStudentInfo(Integer studentId) {
		
		return studentInfoMapper.deleteByPrimaryKey(studentId);
	}

}
