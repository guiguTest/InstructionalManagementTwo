package com.guigu.instructional.marketactive.mapper;

import java.util.List;

import com.guigu.instructional.po.MarketActiveVO;

public interface ActiveVOMapper {
		
	public int addActive(MarketActiveVO marketActiveVO);
	
	public List<MarketActiveVO> activeList();
	
	public int updateActive(MarketActiveVO marketActiveVO);

}
