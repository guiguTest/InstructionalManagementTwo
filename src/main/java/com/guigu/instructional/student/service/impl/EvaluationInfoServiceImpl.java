package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExample;
import com.guigu.instructional.po.EvaluationInfoExample.Criteria;
import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.EvaluationInfoStudentInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeCustom;
import com.guigu.instructional.po.StudentWriteGradeExample;
import com.guigu.instructional.student.mapper.EvaluationInfoAndStudentInfoMapper;
import com.guigu.instructional.student.mapper.EvaluationInfoMapper;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.EvaluationInfoService;
import com.guigu.instructional.student.service.StudentInfoService;


@Service("evaluationInfoServiceImpl")
public class EvaluationInfoServiceImpl implements EvaluationInfoService{

	@Resource(name="evaluationInfoMapper")
	private EvaluationInfoMapper evaluationInfoMapper;
	
	@Resource(name="evaluationInfoAndStudentInfoMapper")
	private EvaluationInfoAndStudentInfoMapper evaluationInfoAndStudentInfoMapper;
	
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
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
	public List<EvaluationInfoExampleVO> getEvaluationInfoList(EvaluationInfo evaluationInfo) {
		List<EvaluationInfoExampleVO> listevaluation=new ArrayList<>();
		EvaluationInfoExample evaluationInfoExample=new EvaluationInfoExample();
		Criteria criteria=evaluationInfoExample.createCriteria();
		if(evaluationInfo!=null && evaluationInfo.getEvaluationTile()!=null) {
			evaluationInfo.setEvaluationTile("%"+evaluationInfo.getEvaluationTile()+"%");
			criteria.andEvaluationTileLike(evaluationInfo.getEvaluationTile());
		}
		
		List<EvaluationInfo> list=evaluationInfoMapper.selectByExample(evaluationInfoExample);
		
		if(list!=null) {
			for(EvaluationInfo evaluationInfo2:list ) {
			EvaluationInfoExampleVO evaluationInfoExampleVO=new EvaluationInfoExampleVO();
			StudentInfo studentInfo=studentInfoMapper.selectByPrimaryKey(evaluationInfo2.getStudentId());
			evaluationInfoExampleVO.setEvaluationInfo(evaluationInfo2);
			evaluationInfoExampleVO.setStudentInfo(studentInfo);
			listevaluation.add(evaluationInfoExampleVO);
			}
			}
		
		return listevaluation;
	}

//	@Override
//	public List<EvaluationInfoExampleVO> getEvaluationInfoList(EvaluationInfo evaluationInfo) {
//		
//		List<EvaluationInfoExampleVO> listevaluation=new ArrayList<>();
//		
//		
//		EvaluationInfoExample evaluationInfoExample=new EvaluationInfoExample();
//		Criteria criteria=evaluationInfoExample.createCriteria();
//		if(evaluationInfo!=null && evaluationInfo.getEvaluationTile()!=null) {
//			evaluationInfo.setEvaluationTile("%"+evaluationInfo.getEvaluationTile()+"%");
//			criteria.andEvaluationTileLike(evaluationInfo.getEvaluationTile());
//		}
//		List<EvaluationInfo> list=evaluationInfoMapper.selectByExample(evaluationInfoExample);
//		
//		if(list!=null) {
//			
//			for(EvaluationInfo evaluation:list) {
//				EvaluationInfoExampleVO evaluationInfoExampleVO=new EvaluationInfoExampleVO();
//				StudentInfo studentinfo=studentInfoMapper.selectByPrimaryKey(evaluation.getStudentId());
//				evaluationInfoExampleVO.setEvaluationInfo(evaluation);
//				
//				evaluationInfoExampleVO.setStudentInfo(studentinfo);
//				
//				listevaluation.add(evaluationInfoExampleVO);
//			}
//		}
//		
//		
//		return listevaluation;
//	}
	
	
	@Override
	public EvaluationInfo getEvaluationInfo(Integer evaluationId) {
		
		return evaluationInfoMapper.selectByPrimaryKey(evaluationId);
	}

	@Override
	public List<EvaluationInfoStudentInfo> findEvaluationList(EvaluationInfoExampleVO evaluationInfoExampleVO) {
		
		return evaluationInfoAndStudentInfoMapper.findEvaluationList(evaluationInfoExampleVO);
	}

	@Override
	public boolean deleteEvaluationInfo(Integer evaluationId) {
		int i=evaluationInfoMapper.deleteByPrimaryKey(evaluationId);
		if(i>0) {
			return true;
		}
		return false;
	}

	


}
