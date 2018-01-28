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
		System.out.println("�����ˡ�����������������������������������������������������������������������"+auditionInfo);
//		if(auditionInfo!=null) {
//			System.out.println(auditionInfo.getAuditionId());
//			System.out.println(auditionInfo.getAuditionCourse());
//			//����ѧ�����name ��ѯ ����ѯ
//			if(auditionInfo.getAuditionId()!=null) {
//				
//				criteria.andStudentIdEqualTo(auditionInfo.getStudentId());
//			}
//			//���ݿγ����Ʋ�ѯ ����ѯ
//			if(auditionInfo.getAuditionCourse()!=null) {
//				criteria.andAuditionCourseEqualTo(auditionInfo.getAuditionCourse());
//			}
//		}
		System.out.println("��ȥ������������������������������������������������������������������������");
		return auditionInfoMapper.selectByExample(auditionInfoExample);
	}

	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

	@Override
	public int deleteAuditionInfo(Integer auditionId) {
		
		return auditionInfoMapper.deleteByPrimaryKey(auditionId);
	}

}
