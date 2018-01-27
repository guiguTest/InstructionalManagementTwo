package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.marketactive.mapper.ActiveVOMapper;
import com.guigu.instructional.marketactive.mapper.MarketActiveMapper;
import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveExample;
import com.guigu.instructional.po.MarketActiveExample.Criteria;
import com.guigu.instructional.po.MarketActiveVO;
@Service("marketActiveServiceImpl")
public class MarketActiveServiceImpl implements MarketActiveService{
	@Resource(name="marketActiveMapper")
	private MarketActiveMapper marketActiveMapper;
	@Resource(name="activeVOMapper")
	private ActiveVOMapper activeVOMapper;
	
	@Override
	public boolean addActive(MarketActive marketActive) {
		try {	
			int i=marketActiveMapper.insertSelective(marketActive);
			   if (i > 0) {
	                return true;
			   }
	    }catch (Exception e) {

	    }
	    return false;
	}

	@Override
	public boolean updateActive(MarketActive marketActive) {
		try {
            int i = marketActiveMapper.updateByPrimaryKeySelective(marketActive);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

	@Override
	public List<MarketActive> getActiveList(MarketActive marketActive) {
		MarketActiveExample marketActiveExample=new MarketActiveExample();
		Criteria criteria=marketActiveExample.createCriteria();
		if(marketActive!=null) {
			if (marketActive.getActiveId()!=null) {
				criteria.andActiveIdEqualTo(marketActive.getActiveId());
			}
			if (marketActive.getActiveState()!=null) {
				criteria.andActiveStateEqualTo(marketActive.getActiveState());
			}
			
		}
		return marketActiveMapper.selectByExample(marketActiveExample);
	}

	@Override
	public MarketActive findActiveById(Integer id) {
		return	marketActiveMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MarketActiveVO> getActiveStaff(MarketActive marketActive) {
		return  activeVOMapper.findVOlist(marketActive);
	}

}
