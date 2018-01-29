package com.guigu.instructional.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.DisciplineInfoExample;
import com.guigu.instructional.po.DisciplineInfoExample.Criteria;

@Service(value="disciplineInfoServiceImpl")
public class DisciplineInfoServiceImpl implements DisciplineInfoService{
	
	@Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;

	@Override
	public List<DisciplineInfo> getDisciplineNameList(DisciplineInfo disciplineInfo) {
		
		DisciplineInfoExample disciplineInfoExample=new DisciplineInfoExample();
		Criteria criteria=disciplineInfoExample.createCriteria();
		
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

}
