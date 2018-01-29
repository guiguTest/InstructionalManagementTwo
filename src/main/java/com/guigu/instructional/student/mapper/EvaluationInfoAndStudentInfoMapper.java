package com.guigu.instructional.student.mapper;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.EvaluationInfoStudentInfo;

public interface EvaluationInfoAndStudentInfoMapper {

	
	public List<EvaluationInfoStudentInfo> findEvaluationList();
}
