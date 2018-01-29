package com.guigu.instructional.po;

import java.util.Date;

public class AuditionInfo {
    private Integer auditionId;

    private Integer studentId;

    private Date auditionTime;

    private String auditionAddr;

    private Integer auditionCourse;

    private String auditionDesc;

    public Integer getAuditionId() {
        return auditionId;
    }

    public void setAuditionId(Integer auditionId) {
        this.auditionId = auditionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getAuditionTime() {
        return auditionTime;
    }

    public void setAuditionTime(Date auditionTime) {
        this.auditionTime = auditionTime;
    }

    public String getAuditionAddr() {
        return auditionAddr;
    }

    public void setAuditionAddr(String auditionAddr) {
        this.auditionAddr = auditionAddr == null ? null : auditionAddr.trim();
    }

    public Integer getAuditionCourse() {
        return auditionCourse;
    }

    public void setAuditionCourse(Integer auditionCourse) {
        this.auditionCourse = auditionCourse;
    }

    public String getAuditionDesc() {
        return auditionDesc;
    }

    public void setAuditionDesc(String auditionDesc) {
        this.auditionDesc = auditionDesc == null ? null : auditionDesc.trim();
    }

	@Override
	public String toString() {
		return "AuditionInfo [auditionId=" + auditionId + ", studentId=" + studentId + ", auditionTime=" + auditionTime
				+ ", auditionAddr=" + auditionAddr + ", auditionCourse=" + auditionCourse + ", auditionDesc="
				+ auditionDesc + "]";
	}
    
    
}