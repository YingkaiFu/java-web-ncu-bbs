package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Activity;
import com.ncu.strong.bbs.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    /**
     * 创建活动 会员或者管理员权限
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseData insertActivity(@RequestBody Activity activity, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            int num = activityService.insert(activity);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("创建失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("创建成功");
            }
        } else {
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 删除活动 会员或者管理员权限
     */
    @RequestMapping(value = "{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.DELETE)
    public ResponseData deleteActivity(@PathVariable("id")Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            int num = activityService.deleteByPrimaryKey(id);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("删除失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("删除成功");
            }
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 更新活动 会员或者管理员权限
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.PUT)
    public ResponseData deleteActivity(@RequestBody Activity activity, HttpSession session) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            int num = activityService.updateByPrimaryKeySelective(activity);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("更新失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("更新成功");
            }
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 查看某一具体活动 所有人
     */
    @RequestMapping(value = "{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getActivityById(@PathVariable("id")Integer id) {
        ResponseData responseData = new ResponseData();
        Activity activity = activityService.getActivityById(id);
        responseData.setCode(1);
        responseData.setMsg("获取活动成功");
        responseData.getData().put("activity",activity);
        return responseData;
    }

    /**
     * 查看最热活动 所有人
     */
    @RequestMapping(value = "/host",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getHostActivity() {
        ResponseData responseData = new ResponseData();
        List list = activityService.getHostActivity();
        responseData.setCode(1);
        responseData.setMsg("获取最热活动成功");
        responseData.getData().put("activities",list);
        return responseData;
    }

    /**
     * 查看最新活动 所有人
     */
    @RequestMapping(value = "/latest",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getLatestActivity() {
        ResponseData responseData = new ResponseData();
        List list = activityService.getLatestActivity();
        responseData.setCode(1);
        responseData.setMsg("获取最新活动成功");
        responseData.getData().put("activities",list);
        return responseData;
    }
}