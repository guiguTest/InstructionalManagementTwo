package com.guigu.instructional.marketactive.service;


import java.util.List;

import com.guigu.instructional.po.MarketActive;

public interface MarketActiveService {
	
	public boolean addActive(MarketActive marketActive);
	
	public boolean updateActive(MarketActive marketActive);
	
	public List<MarketActive> getActiveList(MarketActive marketActive);
	
	public MarketActive findActiveById(Integer id);
}
