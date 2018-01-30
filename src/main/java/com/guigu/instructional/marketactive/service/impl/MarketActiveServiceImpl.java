package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.guigu.instructional.marketactive.mapper.ActiveVOMapper;
import com.guigu.instructional.marketactive.mapper.MarketActiveMapper;
import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveExample;
import com.guigu.instructional.po.MarketActiveExample.Criteria;
import com.guigu.instructional.po.MarketActiveVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
@Service("marketActiveServiceImpl")
public class MarketActiveServiceImpl implements MarketActiveService{
	@Resource(name="marketActiveMapper")
	private MarketActiveMapper marketActiveMapper;
	
	@Resource(name="activeVOMapper")
	private ActiveVOMapper activeVOMapper;
	
	@Resource(name="staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;

	@Override
	public boolean updateActive(MarketActiveVO marketActiveVO) {
		try {
            int i = activeVOMapper.updateActive(marketActiveVO);
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
	public MarketActiveVO findActiveById(Integer activeId) {
		String staffName=null;
		MarketActive marketActive=marketActiveMapper.selectByPrimaryKey(activeId);
		StaffInfo staffInfo=staffInfoMapper.selectByPrimaryKey(marketActive.getStaffId());
		if(staffInfo!=null) {
			staffName=staffInfo.getStaffName();
		}
		MarketActiveVO marketActiveVO=new MarketActiveVO();
		try {
			BeanUtils.copyProperties(marketActiveVO, marketActive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		marketActiveVO.setStaffName(staffName);
		return marketActiveVO;
	}

	@Override
	public boolean addActive(MarketActiveVO marketActiveVO) {
		try {
            int i = activeVOMapper.addActive(marketActiveVO);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }
	
	@Override
	public List<MarketActiveVO> getActiveStaff() {
		return activeVOMapper.activeList();
	}

	@Override
	public boolean deleteActive(MarketActive marketActive) {
		int i=marketActiveMapper.updateByPrimaryKey(marketActive);
		if (i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<MarketActive> getMarketActive(Integer staffId) {
		MarketActiveExample marketActiveExample=new MarketActiveExample();
		Criteria criteria=marketActiveExample.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return marketActiveMapper.selectByExample(marketActiveExample);
	}
}
