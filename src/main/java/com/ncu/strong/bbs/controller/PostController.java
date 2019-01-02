package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Post;
import com.ncu.strong.bbs.po.Theme;
import com.ncu.strong.bbs.po.User;
import com.ncu.strong.bbs.service.PostService;
import com.ncu.strong.bbs.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value={"/post"})
public class PostController {
    private final ThemeService themeService;

    private final PostService postService;

    private final HttpSession session;

    @Autowired
    public PostController(PostService postService, HttpSession session, ThemeService themeService) {
        this.postService = postService;
        this.session = session;
        this.themeService = themeService;
    }

    /**
     * 获取当前分区的所有帖子
     */
    @GetMapping(value = "listSetionPosts")
    public ResponseData getPostsBySetionId(
            @RequestParam(name = "setionId", required = true, defaultValue = "1") Integer setionId) {
        ResponseData responseData = new ResponseData();

        List<Post> posts = postService.getPostsBySetionId(setionId);
        responseData.getData().put("posts", posts);
        responseData.setCode(1);
        responseData.setMsg("获取分区" + setionId + "信息成功");

        return responseData;
    }

    /**
     * 获取最热帖
     */
    @RequestMapping(value={"/getHostPosts"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<Post> getHotPosts(){
       return postService.findHostPosts();
    }

    /**
     * 获取最新贴
     */
    @RequestMapping(value={"/getNewestPosts"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<Post> getNewPosts(){
        return postService.findNewestPosts();
    }

    /**
     * 添加帖子
     */
    @PostMapping(value={"/addPost"}, consumes = "application/json")
    public ResponseData addPost(@RequestBody Post post){
        System.out.println(post.toString());
        ResponseData responseData = new ResponseData();

        // if(session.getAttribute("account") != null)
        if (postService.addPost(post) > 0) {
            responseData.setCode(1);
            responseData.setMsg("添加成功");
        } else {
            responseData.setCode(0);
            responseData.setMsg("添加失败");
        }

        return responseData;
    }

    /**
     * 删除帖子
     */
    @PostMapping(value={"/deletePost"})
    public ResponseData  deletePost(@RequestBody Integer id){
        ResponseData responseData = new ResponseData();
        if(session.getAttribute("accountId") != null) {
            Integer accountId = (Integer) session.getAttribute("accountId");
            Post post = postService.findPostById(id);
            if (accountId == post.getAuthorId()) {
                if (postService.deletePostById(id) == 1) {
                    responseData.setCode(1);
                    responseData.setMsg("删除成功");
                } else {
                    responseData.setCode(0);
                    responseData.setMsg("删除失败");
                }
            } else {
                responseData.setCode(0);
                responseData.setMsg("没有权限");
            }
        }
        return responseData;
    }

    /**
     * 更新帖子
     */
    @PostMapping(value={"/updatePost"})
    public String updatePost(@RequestBody Post post){
        if(session.getAttribute("accountId") != null) {
            if (post != null) {
                if (postService.updatePost(post) == 1) {
                    return "更新成功";
                } else {
                    return "更新失败";
                }
            }
            return "帖子为空";
        }
        return "请登陆";
    }

    /**
     * 获取当前用户的所有帖子
     */
    @PostMapping(value={"/getUsersPosts"})
    public List getUsersPosts(@RequestBody User user){
        //Integer accountid = (Integer)session.getAttribute("accountId");
        Integer accountId = user.getUserAccountId();
        return postService.getUsersPosts(accountId);
    }

    /**
     * 删除当前用户的所有帖子
     */
    @PostMapping(value={"/deleteUsersPosts"})
    public String deleteUsersPosts(@RequestBody User user){
        if(session.getAttribute("accountId") != null || session.getAttribute("admin") != null) {
            Integer accountId = user.getUserAccountId();
            if (postService.deleteUsersPosts(accountId) == 1) {
                return "成功删除用户所有帖子";
            }
            return "删除失败";
        }
        return "请登陆";
    }

    /**
     * 获取当前主题下所有帖子
     */
    @GetMapping(value={"/getPostsByThemeId"})
    public List getPostsByThemeId(@RequestParam Integer themeId){
        System.out.println("themeId => " + themeId);
        return postService.getPostsByThemeId(themeId);
    }

    /**
     * 删除当前分区下的所有帖子
     */
    @PostMapping(value={"/deleteBySetionId"})
    public String deletePostBySetionId(@RequestBody Integer id){
        if(session.getAttribute("admin") != null) {
            if (postService.deleteBySetionId(id) == 1) {
                return "删除成功";
            }
            return "删除失败";
        }
        return "没有权限";
    }

    /**
     * 删除当前主题下的所有帖子
     */
    @PostMapping(value={"/deleteByThemeId"})
    public String deleteByTheme(@RequestBody Integer id){
        if(session.getAttribute("accountId") != null || session.getAttribute("admin") != null) {
            if (postService.deleteByThemeId(id) == 1) {
                return "删除成功";
            } else {
                return "删除失败";
            }
        }
        return "请登陆";
    }

    /**
     * 获取置顶帖
     */
    @PostMapping(value={"/getTopPosts"})
    public List getTopPosts(@RequestBody Integer setionId){
        return postService.getTopPosts(setionId);
    }

    /**
     * 获取精品贴
     */
    @PostMapping(value={"/getBoutiquePosts"})
    public List getBoutiquePosts(@RequestBody Integer setionId){

        return postService.getBoutiquePosts(setionId);
    }

    /**
     * 获取热门贴
     */
    @PostMapping(value={"/getHotPosts"})
    public List getHotPosts(@RequestBody Integer setionId){
        return postService.getHotPosts(setionId);
    }
}