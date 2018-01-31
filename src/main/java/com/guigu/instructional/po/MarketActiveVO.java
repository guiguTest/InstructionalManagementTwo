package com.guigu.instructional.po;

import javax.validation.constraints.NotEmpty;

public class MarketActiveVO extends MarketActive{
	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "MarketActiveVO [staffName=" + staffName + "]";
	}

	
}
