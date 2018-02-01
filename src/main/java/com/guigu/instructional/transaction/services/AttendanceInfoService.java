package com.guigu.instructional.transaction.services;

import java.util.List;

import com.guigu.instructional.po.AttendanceInfo;





public interface AttendanceInfoService {
    
    /**
     * addStaff:���Ա����Ϣ
     * @author ����ʦ
     * @param staffInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
    public boolean addAttendance(AttendanceInfo attendanceInfo);
    
    /**
     * updateStaff:����Ա������
     * @author ����ʦ
     * @param staffInfo
     * @return  <br/>
     * @since JDK 1.8
     */
    public boolean updateAttendance(AttendanceInfo attendanceInfo);
    
    /**
     * getStaffInfo:����������ѯԱ����Ϣ
     * @author ����ʦ
     * @param staffInfo
     * @return  <br/>
     * @since JDK 1.8
     */
    public List<AttendanceInfo> getAttendanceInfoList(AttendanceInfo attendanceInfo);
    
    
    /**
     * getStaffInfo:����Ա����Ų�ѯԱ����Ϣ
     * @author ����ʦ
     * @param staffId
     * @return  <br/>
     * @since JDK 1.8
     */
    public AttendanceInfo getAttendanceInfo(Integer attendanceId);
    
    
}


