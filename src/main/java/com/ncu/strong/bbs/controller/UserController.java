package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Account;
import com.ncu.strong.bbs.po.User;
import com.ncu.strong.bbs.service.AccountService;
import com.ncu.strong.bbs.service.UserService;
import com.ncu.strong.bbs.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    private final UserService userService;

    private final AccountService accountService;

    @Autowired
    public UserController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    /**
     * 功能：获取所有用户信息
     * 权限：管理员
     */
    @RequestMapping(
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getAllUsers(){
        List<User> users = userService.findAllUser();
        ResponseData responseData = new ResponseData();
        responseData.getData().put("users", users);
        return  responseData;
    }

    /**
     * 功能：用户登陆
     * 权限：用户
     */
    @PostMapping(
            value = "/logIn",
            consumes = "application/json",
            produces = "application/json")
    public ResponseData login(@RequestBody Account logAccount, HttpServletRequest request){

        System.out.println(logAccount.toString());
        HttpSession session = request.getSession();
        ResponseData responseData = new ResponseData();
        Account account = accountService.getAccountByLoginName(logAccount.getLoginName());
        if (account != null) {
            if (logAccount.equals(account)) {
                responseData.setCode(1);
                responseData.setMsg("登录成功");

                User user = userService.getUserProfileByAccoundId(account.getId());
                responseData.getData().put("user", user);

                session.setAttribute("account", account);
                session.setAttribute("user", user);
            } else{
                responseData.setCode(0);
                responseData.setMsg("密码错误");
            }
        }else{
            responseData.setCode(0);
            responseData.setMsg("用户名不存在");
        }

        return responseData;
    }


    /**
     * 功能：退出登录
     * 权限：用户
     * 描述：将session中的值移出，完成退出登录
     */
    @GetMapping(
            value={"/logOut"})
    public ResponseData logOut(HttpSession session){
        ResponseData responseData = new ResponseData();

        session.removeAttribute("user");
        session.removeAttribute("account");

        responseData.setCode(1);
        responseData.setMsg("成功退出");

        return responseData;
    }

    /**
     * 注册
     */
    @PostMapping(
            value={"/register"},
            consumes = "application/json",
            produces = "application/json")
    public ResponseData register(@RequestBody Account registerAccount){
        ResponseData responseData = new ResponseData();

        // 判断账户是否已经被注册
        Account account = accountService.getAccountByLoginName(registerAccount.getLoginName());
        if (account != null) {
            responseData.setCode(0);
            responseData.setMsg("用户已存在");
        } else {
            if (accountService.insertAccount(registerAccount) > 0) {
                Integer accountId = registerAccount.getId();
                System.out.println("accountId => " + accountId);

                // 封装用户对象
                User user = new User();
                user.setUserAccountId(accountId);
                userService.insertUser(user);

                responseData.setCode(1);
                responseData.setMsg("注册成功");
            } else {
                responseData.setCode(0);
                responseData.setMsg("注册失败，请重新尝试");
            }
        }

        return responseData;
    }

    /**
     * 功能：获取用户信息
     * 权限：用户
     * 描述：从session取出预先存入的用户信息
     */
    @RequestMapping(
            value = {"/getProfile"},
            method = RequestMethod.GET)
    public ResponseData getProfile(HttpServletRequest request){
        ResponseData responseData = new ResponseData();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (user != null) {
            responseData.setCode(1);
            responseData.setMsg("成功获得用户信息");
            responseData.getData().put("user", user);
        } else {
            responseData.setCode(0);
            responseData.setMsg("用户未登录");
        }

        return responseData;
    }

    /**
     * 功能：更新用户信息
     * 权限：用户
     * 描述：更新数据库和session中的信息
     */
    @PostMapping(
            value={"/updateProfile"},
            consumes = "application/json",
            produces = "application/json")
    public ResponseData updateProfile(@RequestBody User updateUser, HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        updateUser.setId(user.getId());
        session.setAttribute("user", updateUser);
        if(userService.updateUser(updateUser) == 1){
            responseData.setCode(1);
            responseData.setMsg("更新信息成功");
        } else {
            responseData.setCode(0);
            responseData.setMsg("更新信息失败");
        }

        return responseData;
    }

    /**
     * 功能：修改密码
     * 权限：用户
     * 描述：更新数据库中密码以及session中的密码
     */
    @PostMapping(
            value = {"/updatePassword"},
            consumes = "application/json",
            produces = "application/json")
    public ResponseData updatePassword(@RequestBody Map<String, Object> updateData, HttpServletRequest request){
        ResponseData responseData = new ResponseData();
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            account.setPassword((String) updateData.get("password"));
            session.setAttribute("account", account);
            if (accountService.updateAccount(account) == 1) {
                responseData.setCode(1);
                responseData.setMsg("更新成功");
            } else {
                responseData.setCode(0);
                responseData.setMsg("更新失败");
            }
        } else {
            responseData.setCode(0);
            responseData.setMsg("用户未登录");
        }

        return responseData;
    }

    /**
     * 功能：修改头像
     * 权限：用户
     */
   @PostMapping(
           value = "/updateAvatar",
           consumes = "application/json",
           produces = "application/json")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, HttpSession session){
       if(session.getAttribute("accountId") != null) {
           Integer profileId = (Integer) session.getAttribute("profileId");
           if (FileUploadUtil.uploadFile(file) == 1) {
               User user = userService.getUserProfileById(profileId);
               user.setAvatar(file.getOriginalFilename());
               userService.updateUser(user);
               return "头像更改成功";
           }
           return "更改失败";
       }
       return "请登陆";
   }

    /**
     * 功能：查询某用户的所有动弹
     * 权限：会员或者管理员权限
     */
    @RequestMapping(
            value = "tweet/{id}",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getTweetsByUser(
            @PathVariable("id")Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            User tweets = userService.getTweetsByUser(id);
            responseData.setCode(1);
            responseData.setMsg("获取用户动弹成功");
            responseData.getData().put("tweets",tweets);
        } else {
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 功能：查询某一用户的所有提问
     * 权限：会员或者管理员
     */
    @RequestMapping(
            value = "question/{id}",
            consumes = "application/json",
            method = RequestMethod.GET)
    public ResponseData getQuestionsByUser(
            @PathVariable("id")Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            User questions =  userService.getQuestionsByUser(id);
            responseData.setCode(1);
            responseData.getData().put("questions",questions);
            responseData.setMsg("获取用户提问成功");

        } else {
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 功能：查询某一用户的所有回答 会员或者管理员权限
     * 权限：用户、管理员
     */
    @RequestMapping(
            value = "answer/{id}",
            consumes = "application/json",
            method = RequestMethod.GET)
    public ResponseData getAnswerByUser(
            @PathVariable("id") Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            User answers = userService.getAnswersByUser(id);
            responseData.setCode(1);
            responseData.setMsg("获取用户答案成功");
            responseData.getData().put("answers",answers);

        } else {
            //response.sendRedirect("/user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }


    /**
     * 功能：查看某用户所创建的所有活动
     * 权限：会员或者管理员权限
     */
    @RequestMapping(value = "create/{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public Object getCreateActivity(@PathVariable("id") Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            User create = userService.getCreateActivity(id);
            responseData.setCode(1);
            responseData.setMsg("获取用户报名活动成功");
            responseData.getData().put("userCreate",create);
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }

    /**
     * 功能：查看某用户参与的所有活动
     * 权限：会员或者管理员权限
     */
    @RequestMapping(value = "enter/{id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseData getEnterActivity(@PathVariable("id") Integer id, HttpSession session) {
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("account") != null ||
                session.getAttribute("admin") != null) {
            User enter = userService.getEnterActivity(id);
            responseData.setCode(1);
            responseData.setMsg("获取用户报名活动成功");
            responseData.getData().put("userEnter",enter);
        } else {
            //response.sendRedirect("user/login.html");
            responseData.setCode(0);
            responseData.setMsg("请先登录");
        }
        return responseData;
    }
}