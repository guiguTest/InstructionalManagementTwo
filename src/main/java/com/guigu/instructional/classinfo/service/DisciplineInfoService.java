package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;

public interface DisciplineInfoService {
	
    /**
     * getAuditionInfoList:����������ѯѧ����Ϣ
     * @author ������
     * @param disciplineInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<DisciplineInfo> getDisciplineNameList(DisciplineInfo disciplineInfo);
}
