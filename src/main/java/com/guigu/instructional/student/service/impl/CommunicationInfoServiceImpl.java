package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.CommunicationInfoCustom;
import com.guigu.instructional.po.CommunicationInfoExample;
import com.guigu.instructional.po.CommunicationInfoExample.Criteria;
import com.guigu.instructional.po.CommunicationInfoStudentInfoStaffInfo;
import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExample;
import com.guigu.instructional.po.EvaluationInfoExampleVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.student.mapper.CommunicationInfoMapper;
import com.guigu.instructional.student.mapper.CommunicationInfoStudentInfoStaffInfoMapper;
import com.guigu.instructional.student.service.CommunicationInfoService;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

@Service("communicationInfoService")
public class CommunicationInfoServiceImpl implements CommunicationInfoService {

	
	@Resource(name="communicationInfoStudentInfoStaffInfoMapper")
	private CommunicationInfoStudentInfoStaffInfoMapper communicationInfoStudentInfoStaffInfoMapper;
	
	@Resource(name="communicationInfoMapper")
	private CommunicationInfoMapper communicationInfoMapper;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
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
	
	@Override
	public List<CommunicationInfoCustom> getCommunicatinList(StudentInfo studentInfo) {
		
	
		CommunicationInfoExample communicationInfoExample=new CommunicationInfoExample();
		Criteria criteria=communicationInfoExample.createCriteria();
		System.out.println("11111111111111111111111111");
		if(studentInfo!=null & studentInfo.getStudentName()!=null) {
			
			List<StudentInfo> list=studentInfoService.getStudentInfoNameList(studentInfo);
			List<Integer> sid=new ArrayList<>();
			if(!list.isEmpty()) {
				for(StudentInfo stu:list) {
					sid.add(stu.getStudentId());
				}
				criteria.andStudentIdIn(sid);
			}else {
				return null;
			}
			
		}
		
		List<CommunicationInfo> list2=communicationInfoMapper.selectByExample(communicationInfoExample);
		
		List<CommunicationInfoCustom> listcommunication=new ArrayList<>();
		if(!list2.isEmpty()) {
			
			
			for(CommunicationInfo communicationInfo:list2 ) {
				CommunicationInfoCustom communicationInfoCustom=new CommunicationInfoCustom();
				communicationInfoCustom.setCommunicationInfo(communicationInfo);
				
				if(communicationInfo.getStudentId()!=null) {
					StudentInfo student=studentInfoService.getStudent(communicationInfo.getStudentId());
					System.out.println("+++++++++++++++++++"+student.getStudentName()+"++++++++++++++");
					communicationInfoCustom.setStudentName(student.getStudentName());
				}
				if(communicationInfo.getStaffId()!=null) {
					StaffInfo staffInfo=staffInfoService.getStaffInfo(communicationInfo.getStaffId());
					communicationInfoCustom.setStudentName(staffInfo.getStaffName());
				}
				
				listcommunication.add(communicationInfoCustom);
				}
				
			}
		
		return listcommunication;
	}

}
