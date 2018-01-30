package com.guigu.instructional.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeStudentInfoStaffInfo;
import com.guigu.instructional.student.mapper.StudentWriteGradeMapper;
import com.guigu.instructional.student.mapper.StudentWriteGradeStudentInfoStaffInfoMapper;
import com.guigu.instructional.student.service.StudentWriteGradeService;

@Service("studentWriteGradeServiceImpl")
public class StudentWriteGradeServiceImpl implements StudentWriteGradeService {

	@Resource(name="studentWriteGradeStudentInfoStaffInfoMapper")
	private StudentWriteGradeStudentInfoStaffInfoMapper studentWriteGradeStudentInfoStaffInfoMapper;
	
	@Resource(name="studentWriteGradeMapper")
	private StudentWriteGradeMapper studentWriteGradeMapper;
	
	@Override
	public List<StudentWriteGradeStudentInfoStaffInfo> findStudentWriteGrade() {
		return studentWriteGradeStudentInfoStaffInfoMapper.findStudentWriteGrade();
	}

	@Override
	public boolean addStudentWriteGrade(StudentWriteGrade studentWriteGrade) {
		int i=studentWriteGradeMapper.insertSelective(studentWriteGrade);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudentWriteGrade(StudentWriteGrade studentWriteGrade) {
		int i=studentWriteGradeMapper.updateByPrimaryKeySelective(studentWriteGrade);
		if(i>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteStudentWriteGrade(Integer writeGradeId) {
		int i=studentWriteGradeMapper.deleteByPrimaryKey(writeGradeId);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public StudentWriteGrade getStudentWriteGrade(Integer writeGradeId) {
		return studentWriteGradeMapper.selectByPrimaryKey(writeGradeId);
	}

}
