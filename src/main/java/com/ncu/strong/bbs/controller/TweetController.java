package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.pojo.Tweet;
import com.ncu.strong.bbs.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/tweet")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;
    /**
     * 根据动弹id查询动弹 所有人
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    public Tweet getTweetById(@PathVariable("id") Integer id) {
        return tweetService.getTweetById(id);
    }

    /**
     * 查询所有动弹 所有人
     * @return
     */
    @RequestMapping(value = "",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    public Object getAllTweets() {
        List list = tweetService.getAllTweets();
        return list;
    }

    /**
     * 根据动弹id删除某一动弹 会员或者管理员权限
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
    public String deleteTweet(@PathVariable("id")Integer id) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = tweetService.deleteByPrimaryKey(id);
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
     * 发布新动弹 会员或者管理员权限
     * @param tweet
     * @return
     */

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String insertTweet(Tweet tweet) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = tweetService.insertSelective(tweet);
            if (num == 0) {
                return "发布失败";
            } else {
                return "发布成功";
            }
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }

    /**
     * 更新动弹 会员或者管理员权限
     * @param record
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateTweet(Tweet record) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = tweetService.updateByPrimaryKeySelective(record);
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

}
