package com.ncu.strong.bbs.controller;


import com.ncu.strong.bbs.pojo.Question;
import com.ncu.strong.bbs.service.QuestionServie;
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
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionServie questionServie;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;

    /**
     * 发出提问 会员或者管理员权限
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String insertQuestion(Question question) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = questionServie.insert(question);
            if (num == 0) {
                return "提问失败";
            } else {
                return "提问成功";
            }
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }

    /**
     * 删除问题 会员或者管理员权限
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String deleteQuestion(@PathVariable("id")Integer id) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = questionServie.delete(id);
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
     * 最热提问 任何人
     * @return
     */
    @RequestMapping(value = "host",method = RequestMethod.GET)
    public List<Question> getAllQuestion() {
        return questionServie.getHostQuestion();
    }

    /**
     * 最新问题
     * @return
     */
    @RequestMapping(value = "latest",method = RequestMethod.GET)
    public List getLatestQuestion() {
        return questionServie.getLatestQuestion();
    }
    /**
     * 查看某一提问 任何人
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Question getQuestionById(@PathVariable("id")Integer id) {
        return questionServie.getQuestionById(id);
    }

    /**
     * 更新问题 会员或者管理员权限
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateQuestion(Question question) throws IOException {
        if(session.getAttribute("accountId") != null || session.getAttribute("admin")!=null) {
            int num = questionServie.updateByPrimaryKeySelective(question);
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
