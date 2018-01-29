package com.guigu.instructional.recruitstudent.mapper;

import java.util.List;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoCustom;
import com.guigu.instructional.po.AuditionInfoVO;

public interface AuditionInfoMapperCustom {
	
	//听课记录查询列表
	public List<AuditionInfoCustom> findAuditionInfoCustomList(AuditionInfoVO auditionInfoVO) throws Exception;

	
}
