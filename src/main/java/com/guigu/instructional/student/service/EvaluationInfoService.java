package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.EvaluationInfoStudentInfo;

public interface EvaluationInfoService {

	public boolean addEvaluation(EvaluationInfo evaluationInfo);
	
	public  boolean updateEvaluation(EvaluationInfo evaluationInfo);
	
	public List<EvaluationInfo> getEvaluationInfoList(EvaluationInfo evaluationInfo);
	
	
	public EvaluationInfo getEvaluationInfo(Integer evaluationId);
	
	public List<EvaluationInfoStudentInfo> findEvaluationList();
	
	public boolean deleteEvaluationInfo(Integer evaluationId);
	
}
