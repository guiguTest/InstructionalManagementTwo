package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.DisciplineInfo;

public interface DisciplineInfoService {
	
    /**
     * getAuditionInfoList:����������ѯѧ����Ϣ
     * @author ������
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<DisciplineInfo> getDisciplineNameList(DisciplineInfo disciplineInfo);
	
    /**
     * getDisciplineInfo:����disciplineId��ѯѧ����Ϣ
     * @author ������
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public DisciplineInfo getDisciplineInfo(Integer disciplineId);
	
    /**
     * getDisciplineList:����������ѯѧ����Ϣ
     * @author ������
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<DisciplineInfo> getDisciplinePoolList(DisciplineInfo disciplineInfo) ;

	public boolean addRole(DisciplineInfo disciplineInfo);
	
	public boolean updateRole(DisciplineInfo disciplineInfo);
	
	public List<DisciplineInfo> getDisciplineInfoList(DisciplineInfo disciplineInfo);
	 
}
