package com.guigu.instructional.marketactive.mapper;

import java.util.List;

import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

public interface ActiveVOMapper {
	
	public List<MarketActiveVO> findVOlist(MarketActive marketActive);
	
	public boolean addActive(MarketActiveVO marketActiveVO);

}
