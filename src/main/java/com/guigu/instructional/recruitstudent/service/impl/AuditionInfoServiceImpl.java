package com.guigu.instructional.recruitstudent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoExample;
import com.guigu.instructional.po.AuditionInfoExample.Criteria;
import com.guigu.instructional.recruitstudent.mapper.AuditionInfoMapper;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.student.mapper.StudentInfoMapper;

@Service(value="auditionInfoServiceImpl")
public class AuditionInfoServiceImpl implements AuditionInfoService{
	
	@Resource(name="auditionInfoMapper")
	private AuditionInfoMapper auditionInfoMapper;
	
	private StudentInfoMapper studentInfoMapper;
	
	private DisciplineInfoMapper disciplineInfoMapper;
	

	@Override
	public boolean addAudition(AuditionInfo auditionInfo) {
		
		int result=auditionInfoMapper.insertSelective(auditionInfo);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean upadteAudition(AuditionInfo auditionInfo) {
		int result=auditionInfoMapper.updateByPrimaryKeySelective(auditionInfo);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<AuditionInfo> getAuditionInfoList(AuditionInfo auditionInfo) {
		
		AuditionInfoExample auditionInfoExample=new AuditionInfoExample();
		Criteria criteria=auditionInfoExample.createCriteria();
		//根据学生name 查询 多表查询

		//根据课程名称查询 多表查询
		
		return auditionInfoMapper.selectByExample(auditionInfoExample);
	}

	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

}
