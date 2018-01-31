package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

public interface MarketActiveService {

	public boolean updateActive(MarketActiveVO marketActiveVO);

	public MarketActiveVO findActiveById(Integer id);

	public List<MarketActive> getActiveStaff(MarketActive marketActive);
	
	
	/**
	 * getActiveList:����������Ų�ѯ�г�Ӫ����Ϣ
	 * 
	 * @author ������
	 * @param marketActive
	 * @return <br/>
	 * @since JDK 1.8
	 */
	public List<MarketActive> getActiveList(MarketActive marketActive);

	public boolean addActive(MarketActiveVO marketActiveVO);

	/**
	 * getMarketActive:����������Ų�ѯ�г�Ӫ����Ϣ
	 * 
	 * @author ������
	 * @param marketActive
	 * @return <br/>
	 * @since JDK 1.8
	 */
	public List<MarketActive> getMarketActive(Integer staffId);

	public boolean deleteActive(Integer activeId);

}