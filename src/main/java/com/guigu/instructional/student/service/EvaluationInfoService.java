package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfo;

public interface EvaluationInfoService {

	public boolean addEvaluation(EvaluationInfo evaluationInfo);
	
	public  boolean updateEvaluation(EvaluationInfo evaluationInfo);
	
	public List<EvaluationInfo> getEvaluationInfoList(EvaluationInfo evaluationInfo);
	
	
	public EvaluationInfo getEvaluationInfo(Integer evaluationId);
	
}
