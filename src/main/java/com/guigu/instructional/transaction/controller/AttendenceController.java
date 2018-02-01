package com.guigu.instructional.transaction.controller;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.AttendanceInfo;

import com.guigu.instructional.transaction.services.AttendanceInfoService;
import com.guigu.instructional.transaction.services.impl.AttendanceInfoServiceImpl;

/**       
 * <p>project_name:InstructionalManagement</p>
 * <p>package_name:com.guigu.instructional.system.controller.StaffInfoController</p>
 * <p>description��</p>
 * <p>@author������ʦ<p>   
 * <p> date:2018��1��26������9:15:58 </p>
 * <p>comments��    </p>
 * <p>@version  jdk1.8</p>
 * 
 * <p>Copyright (c) 2018, 980991634@qq.com All Rights Reserved. </p>    
 */
@Controller
@RequestMapping("/transaction/transaction/")
public class AttendenceController {

    @Resource(name = "attendanceInfoServiceImpl")
    private AttendanceInfoService attendanceInfoService;
    
    private SqlSessionFactory sqlSessionFactory;
//    @RequestMapping("showStudent.action")
//    public String showStudent(Integer studentId,Model model) throws Exception {
//        String resource = "SqlMapConfig.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        
//        
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
//        model.addAttribute("attendanceInfo", attendanceInfo);
//        return "transaction/transaction/transaction_show";
////         �����������
//        AttendanceQueryVO attendanceQueryVO = sqlSession.getMapper(AttendanceQueryVO.class);
//
//        AttendanceQueryVO attendanceQueryVO2 = attendanceQueryVO.findAttendanceInfo(studentId);
//        
//        model.addAttribute("attendanceQueryVO", attendanceQueryVO2);
//        sqlSession.close();
//        return "transaction/transaction/transaction_show";
//
//        
//    }
    
    
    
    // ��������У��  ���ǵĹ���
    @RequestMapping("add.action")
    public String addAttendanceInfo(AttendanceInfo attendanceInfo,Model model) {
    	attendanceInfo.setAttendanceState("1");;
       boolean result= attendanceInfoService.addAttendance(attendanceInfo);
       if(result) {
           model.addAttribute("info","��ӳɹ�");
       }else {
           model.addAttribute("info","���ʧ��");
       }
       return this.list(null, model);
       
    }
    
    @RequestMapping("list.action")
    public String list(AttendanceInfo attendanceInfo,Model model) {
    	
        List<AttendanceInfo> list =attendanceInfoService.getAttendanceInfoList(attendanceInfo);
        System.out.println(list);
        model.addAttribute("list", list);
        
        return "transaction/transaction/transaction_list";
    }
    
    @RequestMapping("show.action")
    public String showAttendanceInfo(Integer attendanceId,Model model) {
    	AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
        model.addAttribute("attendanceInfo", attendanceInfo);
        return "transaction/transaction/transaction_show";
        
    }
  

    
    @RequestMapping("load.action")
    public String loadUpate(Integer attendanceId,Model model) {
    	AttendanceInfo attendanceInfo =attendanceInfoService.getAttendanceInfo(attendanceId);
        model.addAttribute("attendanceInfo", attendanceInfo);
        return "transaction/transaction/transaction_update";
    }
    
    @RequestMapping("update.action")
    public String updateAttendanceInfo(AttendanceInfo attendanceInfo,Model model) {
        boolean result=attendanceInfoService.updateAttendance(attendanceInfo);
        if(result) {
            model.addAttribute("info", "�޸ĳɹ�");
        }else {
            model.addAttribute("info", "�޸�ʧ��");
        }
        return this.list(null, model);
    }
    
    @RequestMapping("delete.action")
    public String deleteAttendanceInfo(AttendanceInfo attendanceInfo,Model model) {
        
        //����Ա��Ϊ 0   ������Ч
    	attendanceInfo.setAttendanceState("0");
        
        boolean result =attendanceInfoService.updateAttendance(attendanceInfo);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }
    

}
