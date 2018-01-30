package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StaffInfoExample;
import com.guigu.instructional.po.StudentCustom;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.student.mapper.StudentInfoMapper;
import com.guigu.instructional.student.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

@Service(value = "studentInfoServiceImpl")
public class StudentInfoServiceImpl implements StudentInfoService {

	@Resource(name = "studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "marketActiveServiceImpl")
	private MarketActiveService marketActiveService;

	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public List<StudentInfo> getStudentNameList(StudentInfo studentInfo) {

		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();
		if (studentInfo.getStudentName() != null && studentInfo.getStudentName() != null) {
			studentInfo.setStudentName("%" + studentInfo.getStudentName() + "%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}
		criteria.andStudentMarkEqualTo(0);
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public boolean addStudentInfo(StudentInfo studentInfo) {

		try {
			int i = studentInfoMapper.insertSelective(studentInfo);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean upadteStudentInfo(StudentInfo studentInfo) {
		try {
			int i = studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public int deleteStudentInfo(Integer studentId) {

		return studentInfoMapper.deleteByPrimaryKey(studentId);
	}

	@Override
	public List<StudentInfo> getStudentInfoPoolList(StudentInfo studentInfo) {

		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();
		criteria.andStudentMarkEqualTo(0);
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public List<StudentCustom> getStudentCustomList(StudentInfo studentInfo, MarketActive marketActive) {
		System.out.println("impl");
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();

		if (studentInfo != null && studentInfo.getStudentName() != null) {
			studentInfo.setStudentName("%" + studentInfo.getStudentName() + "%");
			criteria.andStudentNameLike(studentInfo.getStudentName());
		}

		if (marketActive != null && marketActive.getActiveName() != null) {
			List<MarketActive> marketActiveList=marketActiveService.getActiveList(marketActive);
			if(marketActiveList!=null) {
				List<Integer> slist=new ArrayList<>();
				for (MarketActive market : marketActiveList) {
					slist.add(market.getStaffId());
				}
				criteria.andStaffIdIn(slist);
			}
		}

		criteria.andStudentMarkEqualTo(0);

		List<StudentInfo> studentList = studentInfoMapper.selectByExample(studentInfoExample);
		if (studentList != null) {
			List<StudentCustom> sslist = new ArrayList<>();
			for (StudentInfo student : studentList) {
				StudentCustom studentCustom = new StudentCustom();
				studentCustom.setStudentInfo(student);
				if (student.getStaffId() != null) {
					studentCustom.setStaffName(staffInfoService.getStaffInfo(student.getStaffId()).getStaffName());
					//查询市场名字
					String activeName = null;
					List<MarketActive> marketActives = marketActiveService.getMarketActive(student.getStaffId());
					if (marketActives != null) {
						for (MarketActive active : marketActives) {
							activeName = activeName.concat(","+active.getActiveName());
						}
						studentCustom.setActiveName(activeName);
					}
				}
				System.out.println(studentCustom+"--------");
				sslist.add(studentCustom);
			}
			return sslist;
		} else {
			return null;
		}
	}

}
