package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoClassInfoStaffInfo;
import com.guigu.instructional.po.StudentInfoCustom;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.po.StudentWriteGradeExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.student.mapper.StudentInfoClassInfoStaffInfoMapper;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
import com.guigu.instructional.system.service.StaffInfoService;
import com.guigu.instructional.transaction.mapper.ClassInfoMapper;

@Service("studentInfoServiceImpl")
public class StudentInfoServiceImpl implements StudentInfoService {

	@Resource(name = "studentInfoClassInfoStaffInfoMapper")
	private StudentInfoClassInfoStaffInfoMapper studentInfoClassInfoStaffInfoMapper;

	@Resource(name = "studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;

	@Resource(name = "classInfoMapper")
	private ClassInfoMapper classInfoMapper;

	@Resource(name = "staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;
	

	@Override
	public List<StudentInfoClassInfoStaffInfo> findStudentList() {

		return studentInfoClassInfoStaffInfoMapper.findStudentList();
	}

	@Override
	public boolean addStudent(StudentInfo studentInfo) {
		int i = studentInfoMapper.insertSelective(studentInfo);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudent(StudentInfo studentInfo) {
		int i = studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public StudentInfo getStudent(Integer studentId) {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public List<StudentInfoCustom> getStudentInfoList(StudentInfo studentInfo) {
		

		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();

		if (studentInfo != null && studentInfo.getStudentName() != null) {
			studentInfo.setStudentName("%" + studentInfo.getStudentName() + "%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}

		List<StudentInfo> list = studentInfoMapper.selectByExample(studentInfoExample);
		
		List<StudentInfoCustom> liststudent = new ArrayList<>();
		if (!list.isEmpty()) {
			for (StudentInfo Student : list) {
				StudentInfoCustom studentInfoCustom = new StudentInfoCustom();
				studentInfoCustom.setStudentInfo(Student);
				
				ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(Student.getClassId());
				StaffInfo staffInfo = staffInfoMapper.selectByPrimaryKey(Student.getStaffId());
				
				studentInfoCustom.setStaffName(staffInfo.getStaffName());
				studentInfoCustom.setClassName(classInfo.getClassName());
				liststudent.add(studentInfoCustom);
			}
		}

		return liststudent;

	}

	@Override
	public List<StudentInfo> getStudentInfoNameList(StudentInfo studentInfo) {

		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();

		if (studentInfo != null && studentInfo.getStudentName() != null) {
			studentInfo.setStudentName("%" + studentInfo.getStudentName() + "%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}
		List<StudentInfo> studentlist =studentInfoMapper.selectByExample(studentInfoExample);
		if(studentlist!=null) {
			return studentlist;
		}else {
			return null;
		}
	}
}
