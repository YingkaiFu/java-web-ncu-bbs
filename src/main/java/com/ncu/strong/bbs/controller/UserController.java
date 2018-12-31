package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.pojo.Account;
import com.ncu.strong.bbs.pojo.User;
import com.ncu.strong.bbs.service.AccountService;
import com.ncu.strong.bbs.service.UserService;
import com.ncu.strong.bbs.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpSession session;

    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;


    private FileUtil fileUtil;

    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List getAllUsers(){
        //return "测试";
        return  userService.findAllUser();
    }

    /**
     * 登陆
     * @param account
     * @return
     */
    @PostMapping(value={"/login"})
    public String  login(@RequestBody Account account){

       Account account1 = accountService.getAccountByLoginName(account.getLoginName());
       if(account1 != null){
           String password = account1.getPassword();
           if(password.equals(account.getPassword())){
               session.setAttribute("accountId",account1.getId());
               User user  = userService.getUserProfileByAccoundId(account1.getId());
               session.setAttribute("profileId",user.getId());
               return "登陆成功";
           }else{
               return "密码错误";
           }
       }else{
           return "用户名不存在";
       }
    }

    /**
     * 注册
     * @param account
     * @return
     */
    @PostMapping(value={"/register"})
    public String register(@RequestBody Account account){
        Account account1 = accountService.getAccountByLoginName(account.getLoginName());
        if(account1 != null){
            return "用户名已存在";
        }
        else{
            if(accountService.insertAccount(account) == 1){
                String name = account.getLoginName();
                account = accountService.getAccountByLoginName(name);
                User user = new User();
                user.setUserAccountId(account.getId());
                userService.insertUser(user);
                return "注册成功";
            }
            else{
                return "注册失败";
            }
        }
    }

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value={"/getProfile"},method = RequestMethod.GET)
    public User  getProfile(){
         Integer profileId = (Integer)session.getAttribute("profileId");
         return userService.getUserProfileById(profileId);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping(value={"/updateProfile"})
    public String updateProfile(@RequestBody User user){
        Integer profileId = (Integer) session.getAttribute("profileId");
        System.out.println(profileId);
        user.setId(profileId);
        if(userService.updateUser(user) == 1){
            return "更改信息成功";
        }
        return "更改信息失败";

    }

    /**
     * 修改密码
     * @param password
     * @return
     */
    @RequestMapping(value = {"/updatePassword"},method=RequestMethod.POST)
    public String updatePassword(@RequestBody String password){
        Account account = new Account();
        Integer accountId = (Integer) session.getAttribute("accountId");
        account.setId(accountId);
        account.setPassword(password);
        if(accountService.updateAccount(account) == 1){
            return "修改密码成功";
        }
        return "修改失败";

    }

    /**
     * 找回密码
     * @param account
     * @return
     */
    @PostMapping(value={"/findPassword"})
    public String findPassword(@RequestBody Account account){
        Account account1 = accountService.getAccountByLoginName(account.getLoginName());
         if(account1 != null){
            if(accountService.findPassword(account)==1){
                return "修改成功";
            }else{
                return "修改失败";
            }
        }
        return "用户不存在";
    }

    @RequestMapping(value={"/exit"})
    public String exit(){
        session.invalidate();
        return "成功退出";
    }


    /**
     * 修改头像
     * @param file
     * @return
     */
   @PostMapping("/updateAvatar")
    public String singleFileUpload(@RequestParam("file")MultipartFile file){
       if(session.getAttribute("accountId") != null) {
           Integer profileId = (Integer) session.getAttribute("profileId");
           if (fileUtil.uploadFile(file) == 1) {
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
     * 查询某用户的所有动弹 会员或者管理员权限
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "tweet/{id}",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    public Object getTweetsByUser(@PathVariable("id")Integer id) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            return userService.getTweetsByUser(id);
        } else {
            //response.sendRedirect("/user/login.html");
            return "请先登录！";
        }

    }

    /**
     * 查询某一用户的所有提问 会员或者管理员权限
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "question/{id}",method = RequestMethod.GET)
    public Object getQuestionsByUser(@PathVariable("id")Integer id) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            return userService.getQuestionsByUser(id);

        } else {
            //response.sendRedirect("/user/login.html");
            return "请先登录！";
        }
    }

    /**
     * 查询某一用户的所有回答 会员或者管理员权限
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "answer/{id}",method = RequestMethod.GET)
    public Object getAnswerByUser(@PathVariable("id") Integer id) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            return userService.getAnswersByUser(id);

        } else {
            //response.sendRedirect("/user/login.html");
            return "请先登录！";
        }
    }


    /**
     * 查看某用户所创建的所有活动 会员或者管理员权限
     * @param id
     * @return
     */
    @RequestMapping(value = "create/{id}",method = RequestMethod.GET)
    public Object getCreateActivity(@PathVariable("id") Integer id) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            return userService.getCreateActivity(id);
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }

    /**
     * 查看某用户参与的所有活动 会员或者管理员权限
     * @param id
     * @return
     */
    @RequestMapping(value = "enter/{id}",method = RequestMethod.GET)
    public Object getEnterActivity(@PathVariable("id") Integer id) throws IOException {
        if(session.getAttribute("accountId") != null ||
                session.getAttribute("admin") != null) {
            return userService.getEnterActivity(id);
        } else {
            //response.sendRedirect("user/login.html");
            return "请先登录";
        }
    }



}
