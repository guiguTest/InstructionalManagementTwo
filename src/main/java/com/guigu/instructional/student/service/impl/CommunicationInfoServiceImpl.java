package com.guigu.instructional.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoStudentInfoStaffInfo;
import com.guigu.instructional.student.mapper.CommunicationInfoMapper;
import com.guigu.instructional.student.mapper.CommunicationInfoStudentInfoStaffInfoMapper;
import com.guigu.instructional.student.service.CommunicationInfoService;

@Service("communicationInfoService")
public class CommunicationInfoServiceImpl implements CommunicationInfoService {

	
	@Resource(name="communicationInfoStudentInfoStaffInfoMapper")
	private CommunicationInfoStudentInfoStaffInfoMapper communicationInfoStudentInfoStaffInfoMapper;
	
	@Resource(name="communicationInfoMapper")
	private CommunicationInfoMapper communicationInfoMapper;
	
	@Override
	public List<CommunicationInfoStudentInfoStaffInfo> findCommunication() {
		
		return communicationInfoStudentInfoStaffInfoMapper.findCommunication();
	}


	@Override
	public boolean addCommunication(CommunicationInfo communicationInfo) {
		int i=communicationInfoMapper.insertSelective(communicationInfo);
				if(i>0) {
					return true;
				}
		return false;
	}


	@Override
	public boolean updateCommunication(CommunicationInfo communicationInfo) {
		int i=communicationInfoMapper.updateByPrimaryKeySelective(communicationInfo);
		if(i>0) {
			return true;
		}
		
		return false;
	}


	@Override
	public boolean deleteCommunication(Integer communicationId) {
		int i=communicationInfoMapper.deleteByPrimaryKey(communicationId);
		if(i>0) {
			return true;
		}
		
		return false;
	}


	@Override
	public CommunicationInfo getCommunicationInfo(Integer communicationId) {
		return communicationInfoMapper.selectByPrimaryKey(communicationId);
	}

}
