package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Tweet;
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

    /**
     * 根据动弹id查询动弹 所有人
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getTweetById(@PathVariable("id") Integer id) {

        ResponseData responseData = new ResponseData();
        Tweet tweet = tweetService.getTweetById(id);
        responseData.setCode(1);
        responseData.setMsg("获取动弹成功");
        responseData.getData().put("tweet",tweet);
        return responseData;
    }

    /**
     * 查询所有动弹 所有人
     * @return
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getAllTweets() {
        ResponseData responseData = new ResponseData();
        List list = tweetService.getAllTweets();
        responseData.setCode(1);
        responseData.setMsg("获取成功");
        responseData.getData().put("tweets",list);
        return responseData;
    }

    /**
     * 根据动弹id删除某一动弹 会员或者管理员权限
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",
            consumes = "application/json",
            produces = "application/json",
            method=RequestMethod.DELETE)
    public ResponseData deleteTweet(@PathVariable("id")Integer id) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null || session.getAttribute("admin")!=null) {
            int num = tweetService.deleteByPrimaryKey(id);
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
     * 发布新动弹 会员或者管理员权限
     * @param tweet
     * @return
     */

    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseData insertTweet(@RequestBody Tweet tweet) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null || session.getAttribute("admin")!=null) {
            int num = tweetService.insertSelective(tweet);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("发布失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("发布成功");
            }
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 更新动弹 会员或者管理员权限
     * @param record
     * @return
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.PUT)
    public ResponseData updateTweet(@RequestBody Tweet record) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null || session.getAttribute("admin")!=null) {
            int num = tweetService.updateByPrimaryKeySelective(record);
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
}