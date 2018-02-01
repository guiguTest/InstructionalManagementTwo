package com.guigu.instructional.transaction.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.po.AttendanceInfo;
import com.guigu.instructional.po.AttendanceInfoExample;
import com.guigu.instructional.po.AttendanceInfoExample.Criteria;
import com.guigu.instructional.transaction.mapper.AttendanceInfoMapper;
import com.guigu.instructional.transaction.services.AttendanceInfoService;

/**       
 * <p>project_name:InstructionalManagement</p>
 * <p>package_name:com.guigu.instructional.system.service.impl.StaffInfoServiceImpl</p>
 * <p>description��</p>
 * <p>@author������ʦ<p>   
 * <p> date:2018��1��26������8:59:08 </p>
 * <p>comments��    </p>
 * <p>@version  jdk1.8</p>
 * 
 * <p>Copyright (c) 2018, 980991634@qq.com All Rights Reserved. </p>    
 */

@Service("attendanceInfoServiceImpl")
public class AttendanceInfoServiceImpl implements AttendanceInfoService {

    // @Autowired
    // @Qualifier
    @Resource(name = "attendanceInfoMapper")
    private AttendanceInfoMapper attendanceInfoMapper;

    @Override
    public boolean addAttendance(AttendanceInfo attendanceInfo) {
        try {
            int i = attendanceInfoMapper.insertSelective(attendanceInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean updateAttendance(AttendanceInfo attendanceInfo) {
        try {
            int i = attendanceInfoMapper.updateByPrimaryKeySelective(attendanceInfo);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public List<AttendanceInfo> getAttendanceInfoList(AttendanceInfo attendanceInfo) {
    	AttendanceInfoExample attendanceInfoExample =new AttendanceInfoExample();
        
        Criteria criteria =attendanceInfoExample.createCriteria();
        if(attendanceInfo!=null) {
            //����id��ѯ
            if(attendanceInfo.getAttendanceId()!=null) {
                criteria.andAttendanceIdEqualTo(attendanceInfo.getAttendanceId());
            }
//            //����name��ѯ
//            if(attendanceInfo.getStaffName()!=null) {
//                staffInfo.setStaffName("%"+staffInfo.getStaffName()+"%");
//                criteria.andStaffNameLike(staffInfo.getStaffName());
//            }
//            //���ݵ绰�����ѯ
//            if(staffInfo.getStaffMobilePhone()!=null) {
//                criteria.andStaffMobilePhoneEqualTo(staffInfo.getStaffMobilePhone());
//            }
            //1��������  0����ɾ��
     //       ��ѯ����������Ա��������
    //        attendanceInfo.setAttendanceState("1");
            
        }
        criteria.andAttendanceStateEqualTo("1");
       
        
        return attendanceInfoMapper.selectByExample(attendanceInfoExample);
    }

    @Override
    public AttendanceInfo getAttendanceInfo(Integer attendanceId) {
        
        return attendanceInfoMapper.selectByPrimaryKey(attendanceId);
    }

}
