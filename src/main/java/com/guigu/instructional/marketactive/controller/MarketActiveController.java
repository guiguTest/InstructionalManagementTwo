package com.guigu.instructional.marketactive.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.mapper.ActiveVOMapper;
import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/marketactive/")
public class MarketActiveController {
	
	@Resource(name="marketActiveServiceImpl")
	 private MarketActiveService marketActiveService;
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	
	@RequestMapping("list.action")
	public String activeList(Model model) {
		List<MarketActiveVO> list=marketActiveService.getActiveStaff();
		model.addAttribute("list", list);
		return "marketactive/marketactive/marketactive_list" ;
	}

	@RequestMapping("add.action")
	public String addActive(MarketActiveVO marketActiveVO,Model model) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(marketActiveVO.getStaffName());
		if(staffInfo!=null) {
			marketActiveVO.setStaffId(staffInfo.getStaffId());
		}else{
			marketActiveVO.setStaffId(null);
		}
		boolean flag=marketActiveService.addActive(marketActiveVO);
		if(flag) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info", "添加失败");
		}
		
		return this.activeList(model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer activeId,Model model) {
		MarketActiveVO marketActiveVO=marketActiveService.findActiveById(activeId);
		model.addAttribute("active", marketActiveVO);
		return "marketactive/marketactive/marketactive_update";
	}
	
	@RequestMapping("update.action")
	public String update(MarketActiveVO marketActiveVO,Model model) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(marketActiveVO.getStaffName());
		if(staffInfo!=null) {
			marketActiveVO.setStaffId(staffInfo.getStaffId());
		}else{
			marketActiveVO.setStaffId(null);
		}
		boolean flag=marketActiveService.updateActive(marketActiveVO);
		if(flag) {
			model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		
		return this.activeList(model);
	}
	
	@RequestMapping("delete.action")
	public String deleteActive(MarketActive marketActive,Model model) {
		marketActive.setActiveState(3);
		boolean flag=marketActiveService.deleteActive(marketActive);
		if(flag) {
			model.addAttribute("info", "刪除成功");
		}else {
			model.addAttribute("info", "刪除失败");
		}
		return this.activeList(model);
	}
}
