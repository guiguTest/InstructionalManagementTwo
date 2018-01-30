package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeStudentInfoStaffInfo;

public interface StudentWriteGradeService {

	public List<StudentWriteGradeStudentInfoStaffInfo> findStudentWriteGrade();
	
	public boolean addStudentWriteGrade(StudentWriteGrade studentWriteGrade);
	
	public boolean updateStudentWriteGrade(StudentWriteGrade studentWriteGrade);
	
	public boolean deleteStudentWriteGrade(Integer writeGradeId);
	
	public StudentWriteGrade getStudentWriteGrade(Integer writeGradeId);
}
