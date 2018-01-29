package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.AuditionStudentDisciplineInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoCustom;
import com.guigu.instructional.po.AuditionInfoVO;

public interface AuditionInfoService {
	
    /**
     * addAudition:���������¼��Ϣ
     * @author ������
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addAudition(AuditionInfo auditionInfo);
	
    /**
     * upadteAudition:����������¼��Ϣ
     * @author ������
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteAudition(AuditionInfo auditionInfo);
	
    /**
     * getAuditionInfoList:����������ѯ������¼��Ϣ
     * @author ������
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionInfoCustom> getAuditionInfoList(AuditionInfoVO auditionInfoVO) throws Exception;
	
    /**
     * getAuditionInfo:����������Ų�ѯ������¼��Ϣ
     * @author ������
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public AuditionInfo getAuditionInfo(Integer auditionId);
	
    /**
     * getAuditionInfo:�����������ɾ��������¼��Ϣ
     * @author ������
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteAuditionInfo(Integer auditionId);
	
    /**
     * getAuditionStudentDisciplineInfoList:����������ѯ������¼��Ϣ
     * @author ������
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionStudentDisciplineInfo> getAuditionStudentDisciplineInfoList(StudentInfo studentInfo,DisciplineInfo disciplineInfo);
	
}
