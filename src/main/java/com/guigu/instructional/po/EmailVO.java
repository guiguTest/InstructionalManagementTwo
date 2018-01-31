package com.guigu.instructional.po;

import javax.validation.constraints.NotEmpty;

public class EmailVO extends EmailInfo{
	@NotEmpty(message="{sendman.isnull}")
	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "EmailVO [staffName=" + staffName + "]";
	}
	
	

}
