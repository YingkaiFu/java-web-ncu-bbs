package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.po.Activity;
import com.ncu.strong.bbs.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    HttpSession session;
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpServletRequest request;

    /**
     * 创建活动 会员或者管理员权限
     * @param activity
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String insertActivity(Activity activity) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            int num = activityService.insert(activity);
            if (num == 0) {
                return "创建失败";
            } else {
                return "创建成功";
            }
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }

    /**
     * 删除活动 会员或者管理员权限
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String deleteActivity(@PathVariable("id")Integer id) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            int num = activityService.deleteByPrimaryKey(id);
            if (num == 0) {
                return "删除失败";
            } else {
                return "删除成功";
            }
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }

    /**
     * 更新活动 会员或者管理员权限
     * @param activity
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String deleteActivity(Activity activity) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            int num = activityService.updateByPrimaryKeySelective(activity);
            if (num == 0) {
                return "更新失败";
            } else {
                return "更新成功";
            }
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }

    /**
     * 查看某一具体活动 所有人
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Object getActivityById(@PathVariable("id")Integer id) {
        return activityService.getActivityById(id);
    }

    /**
     * 查看最热活动 所有人
     * @return
     */
    @RequestMapping(value = "/host", method = RequestMethod.GET)
    public List getHostActivity() {
        return activityService.getHostActivity();
    }

    /**
     * 查看最新活动 所有人
     * @return
     */
    @RequestMapping(value = "/latest",method = RequestMethod.GET)
    public Object getLatestActivity() {
        return activityService.getLatestActivity();
    }

}