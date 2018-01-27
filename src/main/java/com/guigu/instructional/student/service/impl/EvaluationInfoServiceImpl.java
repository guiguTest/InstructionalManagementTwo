package com.guigu.instructional.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExample;
import com.guigu.instructional.po.EvaluationInfoExample.Criteria;
import com.guigu.instructional.student.mapper.EvaluationInfoMapper;
import com.guigu.instructional.student.service.EvaluationInfoService;


@Service("evaluationInfoServiceImpl")
public class EvaluationInfoServiceImpl implements EvaluationInfoService{

	@Resource(name="evaluationInfoMapper")
	private EvaluationInfoMapper evaluationInfoMapper;
	
	@Override
	public boolean addEvaluation(EvaluationInfo evaluationInfo) {
		int i=evaluationInfoMapper.insertSelective(evaluationInfo);
		if(i>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateEvaluation(EvaluationInfo evaluationInfo) {
		
		int i=evaluationInfoMapper.updateByPrimaryKeySelective(evaluationInfo);
		
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<EvaluationInfo> getEvaluationInfoList(EvaluationInfo evaluationInfo) {
		EvaluationInfoExample evaluationInfoExample=new EvaluationInfoExample();
		Criteria criteria=evaluationInfoExample.createCriteria();
		if(evaluationInfo!=null && evaluationInfo.getEvaluationTile()!=null) {
			evaluationInfo.setEvaluationTile("%"+evaluationInfo.getEvaluationTile()+"%");
			criteria.andEvaluationTileLike(evaluationInfo.getEvaluationTile());
		}
		
		return evaluationInfoMapper.selectByExample(evaluationInfoExample);
	}

	@Override
	public EvaluationInfo getEvaluationInfo(Integer evaluationId) {
		
		return evaluationInfoMapper.selectByPrimaryKey(evaluationId);
	}

}
