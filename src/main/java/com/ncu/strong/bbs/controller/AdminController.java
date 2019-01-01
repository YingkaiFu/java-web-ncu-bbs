package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Admin;
import com.ncu.strong.bbs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    HttpSession session;

    @Autowired
    AdminService adminService;

    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;


    /**
     * 管理员登陆
     * @param admin 传入的admin对象
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseData login(Admin admin) throws IOException {

        String adminName = "strong";
        String adminPassword = "StrongAdmin";
        ResponseData responseData = new ResponseData();

        if(adminName.equals(admin.getName()) && adminPassword.equals(admin.getPassword())) {
            session.setAttribute("admin",admin);
            //response.sendRedirect("admin/index.html");
            responseData.setCode(1);
            responseData.setMsg("管理员登录成功");
        }
        else {
            responseData.setCode(0);
            responseData.setMsg("账号或者密码错误");
        }
        return responseData;
    }

    /**
     * 管理员退出登录
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/logout",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData logout() throws IOException {
        ResponseData responseData = new ResponseData();

        if(session != null && session.getAttribute("admin") != null) {
            session.removeAttribute("admin");
            //response.sendRedirect("admin/login.html");
            responseData.setCode(1);
            responseData.setMsg("退出登录成功");
        }
        else {
            responseData.setCode(0);
            responseData.setMsg("退出登录失败");
        }
        return responseData;

    }
}
