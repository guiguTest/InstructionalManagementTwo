package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionStudentDisciplineInfo;
import com.guigu.instructional.po.StudentInfo;

public interface StudentInfoService {
	
    /**
     * addStudent:添加学生池信息 mark为0的学生
     * @author 王珠玲
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addStudentInfo(StudentInfo studentInfo);
	
    /**
     * upadteStudentInfo:更新学生池信息 mark为0的学生
     * @author 王珠玲
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteStudentInfo(StudentInfo studentInfo);
	
    /**
     * getAuditionInfoList:根据条件查询学生信息信息
     * @author 王珠玲
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */ 
	public List<StudentInfo> getStudentNameList(StudentInfo studentInfo);
	
    /**
     * getAuditionInfo:根据条件编号查询学生信息
     * @author 王珠玲
     * @param studentId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public StudentInfo getStudentInfo(Integer studentId);
	
    /**
     * getAuditionInfo:根据条件编号删除试听记录信息
     * @author 王珠玲
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteStudentInfo(Integer studentId);
	
}
