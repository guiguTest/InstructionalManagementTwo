package com.guigu.instructional.marketactive.service;


import java.util.List;

import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

public interface MarketActiveService {
	
	public boolean updateActive(MarketActiveVO marketActiveVO);
	
	public MarketActiveVO findActiveById(Integer id);
	
	public List<MarketActive> getActiveStaff(MarketActive marketActive);
	
	public boolean addActive(MarketActiveVO marketActiveVO);
	
	public boolean deleteActive(Integer activeId);

}