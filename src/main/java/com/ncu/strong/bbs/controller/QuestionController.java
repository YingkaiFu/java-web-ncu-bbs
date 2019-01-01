package com.ncu.strong.bbs.controller;


import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Question;
import com.ncu.strong.bbs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private HttpSession session;

    /**
     * 发出提问 会员或者管理员权限
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseData insertQuestion(Question question) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = questionService.insert(question);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("提问失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("提问成功");
            }
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 删除问题 会员或者管理员权限
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.DELETE)
    public ResponseData deleteQuestion(@PathVariable("id")Integer id) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = questionService.delete(id);
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
     * 最热提问 任何人
     * @return
     */
    @RequestMapping(value = "host",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getAllQuestion() {
        ResponseData responseData = new ResponseData();
        List list = questionService.getHostQuestion();
        responseData.setCode(1);
        responseData.setMsg("获取最热问答成功");
        responseData.getData().put("questions",list);
        return responseData;
    }

    /**
     * 最新问题
     * @return
     */
    @RequestMapping(value = "latest",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getLatestQuestion() {
        ResponseData responseData = new ResponseData();
        List list = questionService.getLatestQuestion();
        responseData.setCode(1);
        responseData.setMsg("获取最新问答成功");
        responseData.getData().put("questions",list);
        return responseData;
    }
    /**
     * 查看某一提问 任何人
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getQuestionById(@PathVariable("id")Integer id) {
        ResponseData responseData = new ResponseData();
        Question question = questionService.getQuestionById(id);
        responseData.setCode(1);
        responseData.setMsg("获取成功");
        responseData.getData().put("question",question);
        return responseData;
    }

    /**
     * 更新问题 会员或者管理员权限
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.PUT)
    public ResponseData updateQuestion(Question question) throws IOException {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = questionService.updateByPrimaryKeySelective(question);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("更新失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("更新成功");
                return responseData;
            }
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }
}
