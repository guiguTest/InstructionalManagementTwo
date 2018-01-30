package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentCustom;
import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.StudentInfo;

public interface StudentInfoService {
	
    /**
     * addStudent:���ѧ������Ϣ markΪ0��ѧ��
     * @author ������
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addStudentInfo(StudentInfo studentInfo);
	
    /**
     * upadteStudentInfo:����ѧ������Ϣ markΪ0��ѧ��
     * @author ������
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteStudentInfo(StudentInfo studentInfo);
	
    /**
     * getAuditionInfoList:����������ѯѧ����Ϣ��Ϣ
     * @author ������
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */ 
	public List<StudentInfo> getStudentNameList(StudentInfo studentInfo);
	
    /**
     * getAuditionInfoList:����������ѯѧ����Ϣ��Ϣ
     * @author ������
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */ 
	public List<StudentInfo> getStudentInfoPoolList(StudentInfo studentInfo);
	
    /**
     * getStudentInfoCustomList:����������ѯѧ����Ϣ��Ϣ
     * @author ������
     * @param studentInfo marketActive
     * @return  <br/> 
     * @since JDK 1.8
     */ 
	public List<StudentCustom> getStudentCustomList(StudentInfo studentInfo,MarketActive marketActive);
	
    /**
     * getAuditionInfo:����������Ų�ѯѧ����Ϣ
     * @author ������
     * @param studentId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public StudentInfo getStudentInfo(Integer studentId);
/*	
    *//**
     * updateStudentInfo:�������������ȡѧ��
     * @author ������
     * @param studentId
     * @return  <br/> 
     * @since JDK 1.8
     *//*
	public boolean updateStudentInfo(Integer studentId);
*/	
    /**
     * getAuditionInfo:�����������ɾ��������¼��Ϣ
     * @author ������
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteStudentInfo(Integer studentId);
	
}
