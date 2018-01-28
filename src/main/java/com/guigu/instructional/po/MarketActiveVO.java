package com.guigu.instructional.po;


public class MarketActiveVO extends MarketActive {
	
	private String StaffnName;

	public String getStaffnName() {
		return StaffnName;
	}

	public void setStaffnName(String staffnName) {
		StaffnName = staffnName;
	}

	@Override
	public String toString() {
		return "MarketActiveVO [StaffnName=" + StaffnName + "]";
	}
	
	//private StaffInfo staffInfo;
	
	


}
