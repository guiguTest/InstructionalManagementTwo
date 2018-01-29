package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoClassInfoStaffInfo;

public interface StudentInfoService {

	public List<StudentInfoClassInfoStaffInfo> findStudentList();
	
	public boolean addStudent(StudentInfo studentInfo);
	
	public boolean updateStudent(StudentInfo studentInfo);
	
	public StudentInfo getStudent(Integer studentId );
}
