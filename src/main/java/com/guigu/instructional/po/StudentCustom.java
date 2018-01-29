package com.guigu.instructional.po;

public class StudentCustom {
	
	private StudentInfo studentInfo;
	
	private String staffName;

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "StudentCustom [studentInfo=" + studentInfo + ", staffName=" + staffName + "]";
	}
	
	
}
