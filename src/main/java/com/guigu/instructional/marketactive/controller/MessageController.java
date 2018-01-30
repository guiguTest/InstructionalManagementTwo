package com.guigu.instructional.marketactive.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.MessageService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailVO;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageVO;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/messageinfo/")
public class MessageController {
	@Resource(name = "messageServiceImpl")
	private MessageService messageService;
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@RequestMapping("list.action")
	public String msgList(MessageInfo messageInfo, Model model) {
		List<MessageInfo> list = messageService.getMsgStaff(messageInfo);
		model.addAttribute("list", list);
		return "marketactive/messageinfo/messageinfo_list";
	}
	@RequestMapping("add.action")
	public String addMsg(MessageVO messageVO,Model model) {
		StaffInfo staffInfo= staffInfoService.getStaffInfo(messageVO.getStaffName());
		if(staffInfo!=null) {
			messageVO.setStaffId(staffInfo.getStaffId());
		}else {
			messageVO.setStaffId(null);
		}
		messageVO.setMessageTime(new Date());
		messageVO.setMessageState("已发送");
		boolean flag=messageService.addMsg(messageVO);
		if(flag) {
			model.addAttribute("info", "发送成功");
		}else {
			model.addAttribute("info", "发送失败");
		}
		
		return this.msgList(null,model);
	}
	
	@RequestMapping("load.action")
	public String load(Integer msgId,Model model) {
		MessageVO messageVO =messageService.findMsgById(msgId);
		messageVO.setStaffName(staffInfoService.getStaffInfo(messageVO.getStaffId()).getStaffName());
		model.addAttribute("msg", messageVO);
		return "marketactive/messageinfo/messageinfo_show";
	}
	
	@RequestMapping("delete.action")
	public String deleteMsg(MessageInfo messageInfo,Model model) {
		boolean flag=messageService.deleteMsg(messageInfo.getMessageId1());
		if(flag) {
			model.addAttribute("info", "刪除成功");
		}else {
			model.addAttribute("info", "刪除失败");
		}
		return this.msgList(null,model);
	}
	
}
