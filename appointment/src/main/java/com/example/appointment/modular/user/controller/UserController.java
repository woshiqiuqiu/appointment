package com.example.appointment.modular.user.controller;


import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.appointment.modular.admin.entity.Admin;
import com.example.appointment.modular.admin.service.IAdminService;
import com.example.appointment.modular.doctor.entity.Doctor;
import com.example.appointment.modular.doctor.service.IDoctorService;
import com.example.appointment.modular.patient.entity.Patient;
import com.example.appointment.modular.patient.service.IPatientService;
import com.example.appointment.modular.user.entity.User;
import com.example.appointment.modular.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService service;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPatientService patientService;

//    /**
//     * 登陆
//     */
//    @PostMapping("/login")
//    @ApiOperation(value = "用户登陆")
//    public String login(@RequestBody User user) {
//        List<User> userList = service.selectUser();
//        for(User userInfo : userList){
//            if (userInfo.getRole().equals(user.getRole())){
//                if (userInfo.getName().equals(user.getName())||userInfo.getPassword().equals(user.getPassword())){
//                    return "true";
//                }else{
//                    return "false";
//                }
//            }else {
//                return "该用户不存在";
//            }
//        }
//        return "";
//
//    }


    /**
     * 登陆
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登陆")
    public String login(User user, HttpSession session, HttpServletResponse response, String pwdcokie) {
        List<User> userList = service.selectUser(user.getName(),user.getPassword());
        if(ObjectUtils.isEmpty(userList)){
            return "false";
        }else{
            if (userList.size() > 0){
                session.setAttribute("user", userList.get(0));
                if (pwdcokie != null) {
                    //把用户信息存入cookie
                    //从对象中取出名字 密码
                    String name = user.getName();
                    String pwd = user.getPassword();
                    // new cookie 空间
                    Cookie cname = new Cookie("name", name);
                    Cookie cpwd = new Cookie("pwd", pwd);
                    //设置cookie过期时间
                    cname.setMaxAge(60 * 60);
                    cpwd.setMaxAge(60 * 60);
                    //设置全路径
                    cname.setPath("/");
                    cpwd.setPath("/");
                    //响应请求 存入cookie
                    response.addCookie(cname);
                    response.addCookie(cpwd);
                } else {
                    String name = user.getName();
                    String pwd = user.getPassword();
                    // new cookie 空间
                    Cookie cname = new Cookie("name", name);
                    Cookie cpwd = new Cookie("pwd", pwd);
                    //设置cookie过期时间
                    cname.setMaxAge(0);
                    cpwd.setMaxAge(0);
                    //设置全路径
                    cname.setPath("/");
                    cpwd.setPath("/");
                    //响应请求 存入cookie
                    response.addCookie(cname);
                    response.addCookie(cpwd);
                }
                //把用户名放入session
                session.setAttribute("p", pwdcokie);
                session.setAttribute("name", userList.get(0).getName());
                return "true";
            }
        }
        return "success";
    }


    /**
     * 注册
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Boolean register( @RequestBody User user) {
        service.save(user);
        if(user.getRole().equals("0")){
            Admin admin = new Admin();
            admin.setAdminName(user.getName());
            admin.setAdminPassword(user.getPassword());
            adminService.save(admin);
        }else if(user.getRole().equals("1")){
            Doctor doctor = new Doctor();
            doctor.setDoctorId(user.getId());
            doctor.setDepartmentName(user.getName());
            doctor.setDoctorSex(user.getSex());
            doctor.setTelphone(user.getTelphone());
            doctor.setDepartmentId(user.getDepartmentId());
            doctor.setIdCard(user.getIdCard());
            doctorService.save(doctor);
        }else if(user.getRole().equals("2")){
            Patient patient = new Patient();
            patient.setPatientId(user.getId());
            patient.setName(user.getName());
            patient.setAge(user.getAge());
            patient.setSex(user.getSex());
            patient.setAddress(user.getAddress());
            patient.setIdCard(user.getIdCard());
            patient.setTelphone(user.getTelphone());
            patient.setTime(LocalDateTime.now());
            patient.setNativePlace(user.getAddress());
            patientService.save(patient);
        }
        return true;
    }
}
