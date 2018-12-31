package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.pojo.Answer;
import com.ncu.strong.bbs.service.AnswerService;
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
@RequestMapping(value = "/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    HttpSession session;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;
    /**
     * 回答问题 会员或者管理员权限
     * @param answer
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String insertAnswer(Answer answer) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = answerService.insert(answer);
            if (num == 0) {
                return "回答失败";
            } else {
                return "回答成功";
            }
        }
        else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }

    }

    /**
     * 删除某一问题 会员或者管理员权限
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String deleteAnswer(@PathVariable("id")Integer id) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = answerService.deleteByPrimaryKey(id);
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
     * 更新回答 会员或者管理员权限
     * @param answer
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateAnswer(Answer answer) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {

            int num = answerService.updateByPrimaryKeySelective(answer);
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
     * 查看某一回答 任何人
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Answer selectAnswer(@PathVariable("id")Integer id) {
       Answer answer  = answerService.getAnswerById(id);
       return answer;
    }
}
