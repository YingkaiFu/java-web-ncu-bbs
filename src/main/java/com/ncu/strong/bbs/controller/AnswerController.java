package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Answer;
import com.ncu.strong.bbs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    /**
     * 回答问题 会员或者管理员权限
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseData insertAnswer(@RequestBody Answer answer, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = answerService.insert(answer);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("回答失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("回答成功");
            }
        }
        else {
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return  responseData;

    }

    /**
     * 删除某一问题 会员或者管理员权限
     */
    @RequestMapping(value = "{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.DELETE)
    public ResponseData deleteAnswer(@PathVariable("id")Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = answerService.deleteByPrimaryKey(id);
            if (num == 0) {
                responseData.setCode(0);
                responseData.setMsg("删除失败");
            } else {
                responseData.setCode(1);
                responseData.setMsg("删除成功");
            }
        } else {
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 更新回答 会员或者管理员权限
     */
    @RequestMapping(value = "",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.PUT)
    public ResponseData updateAnswer(@RequestBody Answer answer, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = answerService.updateByPrimaryKeySelective(answer);
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
     * 查看某一回答 任何人
     */
    @RequestMapping(value = "{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData selectAnswer(@PathVariable("id")Integer id) {
        ResponseData responseData = new ResponseData();
        Answer answer  = answerService.getAnswerById(id);
        responseData.setCode(1);
        responseData.setMsg("获取答案成功");
        responseData.getData().put("answer",answer);
       return responseData;
    }
}
