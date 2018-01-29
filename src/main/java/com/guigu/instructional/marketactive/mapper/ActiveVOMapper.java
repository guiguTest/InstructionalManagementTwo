package com.guigu.instructional.marketactive.mapper;

import java.util.List;

import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

public interface ActiveVOMapper {
		
	public void addActive(MarketActiveVO marketActiveVO);
	
	public List<MarketActiveVO> activeList();
	
}
