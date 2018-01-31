package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class StudentInfo {
	
    private Integer studentId;
    
    @NotNull(message="{studentInfo.staffId.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    private Integer staffId;

    private Integer classId;
    
    @NotEmpty(message="{studentInfo.studentName.notempty}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    @Pattern(regexp = "/^[/u4e00-/u9fa5]*$/", message = "{studentInfo.studentName}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    private String studentName;

    private String studentSex;

    private Integer studentAge;
    
    
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$", message = "{studentInfo.studentIdcard}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    private String studentTellphone;
    
    @Email(message="{studentInfo.studentEmail.email}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    private String studentEmail;
    
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$", message = "{studentInfo.studentIdcard}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    private String studentIdcard;

    private String studentAddress;

    @NotNull(message="{studentInfo.studentBirthday.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    @Past(message="{studentInfo.studentBirthday.past}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    private Date studentBirthday;

    private String studentSchool;

    private String studentQq;

    private String studentParentsName;
    
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$", message = "{studentInfo.studentIdcard}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    private String studentParentsPhone;

    private String studentPro;

    private String studentProCity;

    private String studentType;

    private String studentIspay;

    private String studentState;

    private Integer studentMark;

    private String studentDesc;

    @NotNull(message="{studentInfo.studentNumber.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    @Length(min=5, max=20, message="{studentInfo.studentNumber.length}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    @Pattern(regexp = "^[a-zA-Z]\\w{4,19}$", message = "{studentInfo.studentNumber}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    private String studentNumber;

    @NotNull(message="{studentInfo.studentPassword.isnull}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class})
    @Length(min=6, max=20, message="{studentInfo.studentPassword.length}",groups= {ValidGroupUpdate.class,ValidGroupAdd.class}) 
    private String studentPassword;

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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentTellphone() {
        return studentTellphone;
    }

    public void setStudentTellphone(String studentTellphone) {
        this.studentTellphone = studentTellphone == null ? null : studentTellphone.trim();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public String getStudentIdcard() {
        return studentIdcard;
    }

    public void setStudentIdcard(String studentIdcard) {
        this.studentIdcard = studentIdcard == null ? null : studentIdcard.trim();
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress == null ? null : studentAddress.trim();
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool == null ? null : studentSchool.trim();
    }

    public String getStudentQq() {
        return studentQq;
    }

    public void setStudentQq(String studentQq) {
        this.studentQq = studentQq == null ? null : studentQq.trim();
    }

    public String getStudentParentsName() {
        return studentParentsName;
    }

    public void setStudentParentsName(String studentParentsName) {
        this.studentParentsName = studentParentsName == null ? null : studentParentsName.trim();
    }

    public String getStudentParentsPhone() {
        return studentParentsPhone;
    }

    public void setStudentParentsPhone(String studentParentsPhone) {
        this.studentParentsPhone = studentParentsPhone == null ? null : studentParentsPhone.trim();
    }

    public String getStudentPro() {
        return studentPro;
    }

    public void setStudentPro(String studentPro) {
        this.studentPro = studentPro == null ? null : studentPro.trim();
    }

    public String getStudentProCity() {
        return studentProCity;
    }

    public void setStudentProCity(String studentProCity) {
        this.studentProCity = studentProCity == null ? null : studentProCity.trim();
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType == null ? null : studentType.trim();
    }

    public String getStudentIspay() {
        return studentIspay;
    }

    public void setStudentIspay(String studentIspay) {
        this.studentIspay = studentIspay == null ? null : studentIspay.trim();
    }

    public String getStudentState() {
        return studentState;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState == null ? null : studentState.trim();
    }

    public Integer getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(Integer studentMark) {
        this.studentMark = studentMark;
    }

    public String getStudentDesc() {
        return studentDesc;
    }

    public void setStudentDesc(String studentDesc) {
        this.studentDesc = studentDesc == null ? null : studentDesc.trim();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }
    
}