package com.guigu.instructional.recruitstudent.mapper;

import java.util.List;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoCustom;
import com.guigu.instructional.po.AuditionInfoVO;

public interface AuditionInfoMapperCustom {
	
	//���μ�¼��ѯ�б�
	public List<AuditionInfoCustom> findAuditionInfoCustomList(AuditionInfoVO auditionInfoVO) throws Exception;

	
}
