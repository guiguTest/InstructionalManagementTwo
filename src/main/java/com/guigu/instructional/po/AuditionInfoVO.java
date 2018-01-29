package com.guigu.instructional.po;

import java.util.List;

public class AuditionInfoVO {

	private AuditionInfo auditionInfo=new AuditionInfo();

	private AuditionInfoCustom auditionInfoCustom=new AuditionInfoCustom();

	private List<AuditionInfoCustom> AuditionInfoCustomList=null;

	public AuditionInfo getAuditionInfo() {
		return auditionInfo;
	}

	public void setAuditionInfo(AuditionInfo auditionInfo) {
		this.auditionInfo = auditionInfo;
	}

	public AuditionInfoCustom getAuditionInfoCustom() {
		return auditionInfoCustom;
	}

	public void setAuditionInfoCustom(AuditionInfoCustom auditionInfoCustom) {
		this.auditionInfoCustom = auditionInfoCustom;
	}

	public List<AuditionInfoCustom> getAuditionInfoCustomList() {
		return AuditionInfoCustomList;
	}

	public void setAuditionInfoCustomList(List<AuditionInfoCustom> auditionInfoCustomList) {
		AuditionInfoCustomList = auditionInfoCustomList;
	}

	@Override
	public String toString() {
		return "AuditionInfoVO [auditionInfo=" + auditionInfo + ", auditionInfoCustom=" + auditionInfoCustom
				+ ", AuditionInfoCustomList=" + AuditionInfoCustomList + "]";
	}
	
	

}
