package com.guigu.instructional.po;

public class StudentWriteGradeCustom extends StudentWriteGrade {

	private StudentInfo studentInfo;
	
	private StaffInfo staffInfo;

	private StudentWriteGrade studentWriteGrade;
	
	private String studentName;
	
	private String staffName;
	
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public StaffInfo getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}

	
	public StudentWriteGrade getStudentWriteGrade() {
		return studentWriteGrade;
	}

	public void setStudentWriteGrade(StudentWriteGrade studentWriteGrade) {
		this.studentWriteGrade = studentWriteGrade;
	}

	@Override
	public String toString() {
		return "StudentWriteGradeCustom [studentInfo=" + studentInfo + ", staffInfo=" + staffInfo
				+ ", studentWriteGrade=" + studentWriteGrade + ", studentName=" + studentName + ", staffName="
				+ staffName + "]";
	}

	
	
}
