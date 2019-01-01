package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.ActivityEnter;
import com.ncu.strong.bbs.service.ActivityEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "enter")
public class ActivityEnterController {

    @Autowired
    private ActivityEnterService activityEnterService;

    @Autowired
    HttpSession session;

    /**
     * 报名活动 会员或者管理员权限
     * @param activityEnter
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseData insertEnter(ActivityEnter activityEnter) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            int num = activityEnterService.insert(activityEnter);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("报名失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("报名成功");
            }
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }
}
