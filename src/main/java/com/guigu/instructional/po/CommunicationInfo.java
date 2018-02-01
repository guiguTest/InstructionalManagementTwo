package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class CommunicationInfo {
    private Integer communicationId;

    private Integer studentId;

    private Integer staffId;

    @NotNull(message="{items.communicationTime.isNULL}")
    @Past(message="{items.communicationTime.dateError}")
    private Date communicationTime;

    private String communicationContent;

    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getCommunicationTime() {
        return communicationTime;
    }

    public void setCommunicationTime(Date communicationTime) {
        this.communicationTime = communicationTime;
    }

    public String getCommunicationContent() {
        return communicationContent;
    }

    public void setCommunicationContent(String communicationContent) {
        this.communicationContent = communicationContent == null ? null : communicationContent.trim();
    }
}