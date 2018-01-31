package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExample;
import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.po.StudentWriteGradeExample;
import com.guigu.instructional.po.StudentWriteGradeStudentInfoStaffInfo;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.mapper.StudentWriteGradeMapper;
import com.guigu.instructional.student.mapper.StudentWriteGradeStudentInfoStaffInfoMapper;
import com.guigu.instructional.student.service.StudentWriteGradeService;
import com.guigu.instructional.system.mapper.StaffInfoMapper;

@Service("studentWriteGradeServiceImpl")
public class StudentWriteGradeServiceImpl implements StudentWriteGradeService {

	@Resource(name="studentWriteGradeStudentInfoStaffInfoMapper")
	private StudentWriteGradeStudentInfoStaffInfoMapper studentWriteGradeStudentInfoStaffInfoMapper;
	
	@Resource(name="studentWriteGradeMapper")
	private StudentWriteGradeMapper studentWriteGradeMapper;
	
	
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	
	@Resource(name="staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;
	
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

	@Override
	public List<StudentWriteGradeCustom> getStudentWriteGradeList(StudentInfo studentInfo) {
		
		List<StudentWriteGradeCustom> liststudentwritegrade=new ArrayList<>();
		StudentInfoExample studentInfoExample=new StudentInfoExample();
		Criteria criteria=studentInfoExample.createCriteria();
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			studentInfo.setStudentName("%"+studentInfo.getStudentName()+"%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}
		
		List<StudentInfo> list=studentInfoMapper.selectByExample(studentInfoExample);
		
		StudentWriteGradeExample studentWriteGradeExample=new StudentWriteGradeExample();
		com.guigu.instructional.po.StudentWriteGradeExample.Criteria criteria2=studentWriteGradeExample.createCriteria();
		List<StudentWriteGrade> list2=studentWriteGradeMapper.selectByExample(null);
		if(list2!=null) {
			for(StudentWriteGrade StudentWriteGrade:list2 ) {
				StudentWriteGradeCustom studentWriteGradeCustom=new StudentWriteGradeCustom();
			StudentInfo student1=studentInfoMapper.selectByPrimaryKey(StudentWriteGrade.getStudentId());
			StaffInfo staffInfo=staffInfoMapper.selectByPrimaryKey(StudentWriteGrade.getStaffId());
			studentWriteGradeCustom.setStudentWriteGrade(StudentWriteGrade);
			studentWriteGradeCustom.setStaffInfo(staffInfo);
			studentWriteGradeCustom.setStudentInfo(student1);
			liststudentwritegrade.add(studentWriteGradeCustom);
			}
			}
		
		return liststudentwritegrade;
	}

}
