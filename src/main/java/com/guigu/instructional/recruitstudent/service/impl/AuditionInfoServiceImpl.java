package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.classinfo.service.DisciplineInfoService;
import com.guigu.instructional.po.AuditionStudentDisciplineInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoCustom;
import com.guigu.instructional.po.AuditionInfoExample;
import com.guigu.instructional.po.AuditionInfoExample.Criteria;
import com.guigu.instructional.po.AuditionInfoVO;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.recruitstudent.mapper.AuditionInfoMapper;
import com.guigu.instructional.recruitstudent.mapper.AuditionInfoMapperCustom;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.StudentInfoService;

@Service(value = "auditionInfoServiceImpl")
public class AuditionInfoServiceImpl implements AuditionInfoService {

	@Resource(name = "auditionInfoMapper")
	private AuditionInfoMapper auditionInfoMapper;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name = "disciplineInfoServiceImpl")
	private DisciplineInfoService disciplineInfoService;
	
	@Resource(name = "auditionInfoMapperCustom")
	private AuditionInfoMapperCustom auditionInfoMapperCustom;

	@Override
	public boolean addAudition(AuditionInfo auditionInfo) {

		int result = auditionInfoMapper.insertSelective(auditionInfo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean upadteAudition(AuditionInfo auditionInfo) {
		int result = auditionInfoMapper.updateByPrimaryKeySelective(auditionInfo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<AuditionInfoCustom> getAuditionInfoList(AuditionInfoVO auditionInfoVO) throws Exception{
		
		return auditionInfoMapperCustom.findAuditionInfoCustomList(auditionInfoVO);
	}

	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

	@Override
	public int deleteAuditionInfo(Integer auditionId) {

		return auditionInfoMapper.deleteByPrimaryKey(auditionId);
	}

	@Override
	public List<AuditionStudentDisciplineInfo> getAuditionStudentDisciplineInfoList(StudentInfo studentInfo,DisciplineInfo disciplineInfo){
		
		AuditionInfoExample auditionInfoExample=new AuditionInfoExample();
		Criteria criteria=auditionInfoExample.createCriteria();
		
		if(studentInfo!=null && studentInfo.getStudentName()!=null) {
			
			List<StudentInfo> studentList=studentInfoService.getStudentNameList(studentInfo);
			List<Integer> slist=new ArrayList<>();
			
			for (StudentInfo student : studentList) {
				slist.add(student.getStudentId());
			}
			criteria.andStudentIdIn(slist);
		}
		
		if(disciplineInfo!=null && disciplineInfo.getDisciplineName()!=null) {
			
			List<DisciplineInfo> disciplineList=disciplineInfoService.getDisciplineNameList(disciplineInfo);
			List<Integer> dlist=new ArrayList<>();
			
			for (DisciplineInfo discipline : disciplineList) {
				dlist.add(discipline.getDisciplineId());
			};
			criteria.andAuditionCourseIn(dlist);
		}
		
		List<AuditionInfo> auditionList=auditionInfoMapper.selectByExample(auditionInfoExample);
		List<AuditionStudentDisciplineInfo> asdlist=new ArrayList<>();
		for (AuditionInfo auditionInfo : auditionList) {
			AuditionStudentDisciplineInfo auditionStudentDisciplineInfo=new AuditionStudentDisciplineInfo();
			auditionStudentDisciplineInfo.setAuditionInfo(auditionInfo);
			auditionStudentDisciplineInfo.setStudentName(studentInfoService.getStudentInfo(auditionInfo.getStudentId()).getStudentName());
			auditionStudentDisciplineInfo.setDisciplineName(disciplineInfoService.(auditionInfo.getStudentId()).getStudentName());
			asdlist.add(auditionStudentDisciplineInfo);
		}
		
		return asdlist;
		
		
	}
	
}
