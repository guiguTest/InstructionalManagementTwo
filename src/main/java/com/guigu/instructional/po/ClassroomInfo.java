package com.guigu.instructional.po;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClassroomInfo {
    @Override
	public String toString() {
		return "ClassroomInfo [classroomId=" + classroomId + ", classroomName=" + classroomName + ", classroomMax="
				+ classroomMax + ", classroomInfo=" + classroomInfo + ", classroomRemark=" + classroomRemark
				+ ", classroomMark=" + classroomMark + ", classInfo=" + classInfo + "]";
	}

	private Integer classroomId;
	
	@Size(min=2,max=10,message="{classroominfo.name.length.error}")
	@Pattern(regexp="^[\u4e00-\u9fa5]*$",message="{classroominfo1.name.length.error}")
    private String classroomName;
	@Min(value=10)
	@NotNull(message="{classroominfo1.classroominfo.name.length.error.length.error}")
    private Integer classroomMax;
    
    @NotEmpty(message="{classroominfo.classroominfo.name.length.error.length.error}")
    private String classroomInfo;

    private String classroomRemark;

    private String classroomMark;
    
    private ClassInfo classInfo;

    public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    public Integer getClassroomMax() {
        return classroomMax;
    }

    public void setClassroomMax(Integer classroomMax) {
        this.classroomMax = classroomMax;
    }

    public String getClassroomInfo() {
        return classroomInfo;
    }

    public void setClassroomInfo(String classroomInfo) {
        this.classroomInfo = classroomInfo == null ? null : classroomInfo.trim();
    }

    public String getClassroomRemark() {
        return classroomRemark;
    }

    public void setClassroomRemark(String classroomRemark) {
        this.classroomRemark = classroomRemark == null ? null : classroomRemark.trim();
    }

    public String getClassroomMark() {
        return classroomMark;
    }

    public void setClassroomMark(String classroomMark) {
        this.classroomMark = classroomMark == null ? null : classroomMark.trim();
    }
}