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
     * addAudition:添加试听记录信息
     * @author 王珠玲
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addAudition(AuditionInfo auditionInfo);
	
    /**
     * upadteAudition:更新试听记录信息
     * @author 王珠玲
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteAudition(AuditionInfo auditionInfo);
	
    /**
     * getAuditionInfoList:根据条件查询试听记录信息
     * @author 王珠玲
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionInfoCustom> getAuditionInfoList(AuditionInfoVO auditionInfoVO) throws Exception;
	
    /**
     * getAuditionInfo:根据条件编号查询试听记录信息
     * @author 王珠玲
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public AuditionInfo getAuditionInfo(Integer auditionId);
	
    /**
     * getAuditionInfo:根据条件编号删除试听记录信息
     * @author 王珠玲
     * @param auditionId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteAuditionInfo(Integer auditionId);
	
    /**
     * getAuditionStudentDisciplineInfoList:根据条件查询试听记录信息
     * @author 王珠玲
     * @param auditionInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<AuditionStudentDisciplineInfo> getAuditionStudentDisciplineInfoList(StudentInfo studentInfo,DisciplineInfo disciplineInfo);
	
}
