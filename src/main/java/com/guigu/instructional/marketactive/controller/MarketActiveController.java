package com.guigu.instructional.marketactive.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveVO;

@Controller
@RequestMapping("/marketactive/marketactive/")
public class MarketActiveController {
	@Resource(name="marketActiveServiceImpl")
	 private MarketActiveService marketActiveService;
	
	@RequestMapping("list.action")
	public String activeList(MarketActive marketActive,Model model) {
		List<MarketActiveVO> list=marketActiveService.getActiveStaff(marketActive);
		model.addAttribute("list", list);
		return "marketactive/marketactive/marketactive_list" ;
	}

		
}
