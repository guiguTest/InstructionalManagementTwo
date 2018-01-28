package com.guigu.instructional.recruitstudent.service;

import java.util.List;

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
     * getAuditionInfoList:����������ѯ������¼��Ϣ
     * @author ������
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionInfo> getAuditionInfoList(AuditionInfo auditionInfo);
	
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
}
