package com.guigu.instructional.po;

public class StudentInfoCustom {

	private ClassInfo classInfo;
	
	private StaffInfo staffInfo;

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public StaffInfo getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}

	@Override
	public String toString() {
		return "StudentInfoCustom [classInfo=" + classInfo + ", staffInfo=" + staffInfo + "]";
	}
	
	
}
