package com.guigu.instructional.po;

import java.util.List;

public class MarketActiveVO {
	
	private MarketActive marketActive;
	
	private StaffInfo staffInfo;
	
	private List<MarketActive> activeList;

	public MarketActive getMarketActive() {
		return marketActive;
	}

	public void setMarketActive(MarketActive marketActive) {
		this.marketActive = marketActive;
	}

	public StaffInfo getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}

	public List<MarketActive> getActiveList() {
		return activeList;
	}

	public void setActiveList(List<MarketActive> activeList) {
		this.activeList = activeList;
	}
	
}
