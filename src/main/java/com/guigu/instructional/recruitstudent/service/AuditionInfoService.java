package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.AuditionCustom;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.AuditionInfo;

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
     * getAuditionCustomList:����������ѯ������¼��Ϣ
     * @author ������
     * @param studentInfo disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionCustom> getAuditionCustomList(StudentInfo studentInfo,DisciplineInfo disciplineInfo);
	
}
