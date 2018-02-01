package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordCustom;
import com.guigu.instructional.po.TrackRecordInfo;

public interface TrackRecordInfoService {
	
	 /**
     * addTrackRecord:���׷�ټ�¼��Ϣ
     * @author ������
     * @param trackRecordInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean addTrackRecord(TrackRecordInfo trackRecordInfo);
	
    /**
     * upadteAudition:����׷�ټ�¼��Ϣ
     * @author ������
     * @param trackRecordInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public boolean upadteTrackRecord(TrackRecordInfo trackRecordInfo);
	
    /**
     * getTrackRecordInfo:����������Ų�ѯ׷�ټ�¼��Ϣ
     * @author ������
     * @param trackRecordId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId);
	
    /**
     * deleteTrackRecordInfo:�����������ɾ��׷�ټ�¼��Ϣ
     * @author ������
     * @param trackRecordId
     * @return  <br/> 
     * @since JDK 1.8
     */
	public int deleteTrackRecordInfo(Integer trackRecordId);
	
    /**
     * getTrackRecordCustomList:����������ѯ������¼��Ϣ
     * @author ������
     * @param studentInfo
     * @return  <br/> 
     * @since JDK 1.8
     */
	public List<TrackRecordCustom> getTrackRecordCustomList(StudentInfo studentInfo);
	
}
