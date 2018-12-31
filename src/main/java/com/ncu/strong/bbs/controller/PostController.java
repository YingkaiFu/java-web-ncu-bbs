package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.pojo.Post;
import com.ncu.strong.bbs.pojo.User;
import com.ncu.strong.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value={"/post"})
public class PostController {

    @Autowired
    private PostService postService;


    @Autowired
    private HttpSession session;

    /**
     * 获取最热帖
     * @return
     */
    @RequestMapping(value={"/getHostPosts"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List getHotPosts(){
       return postService.findHostPosts();
    }

    /**
     * 获取最新贴
     * @return
     */
    @RequestMapping(value={"/getNewestPosts"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List getNewPosts(){
        return postService.findNewestPosts();
    }

    /**
     * 添加帖子
     * @param post
     * @return
     */
    @PostMapping(value={"/addPost"})
    public String addPost(@RequestBody Post post){
        if(session.getAttribute("accountId") != null) {
            if (post != null) {
                if (postService.addPost(post) == 1) {
                    return "添加成功";
                } else {
                    return "添加失败";
                }
            }
            return "帖子为空";
        }
        return "请登陆";
    }

    /**
     * 删除帖子
     * @param id
     * @return
     */
    @PostMapping(value={"/deletePost"})
    public String  deletePost(@RequestBody Integer id){
        if(session.getAttribute("accountId") != null) {
            Integer accountId = (Integer) session.getAttribute("accountId");
            Post post = postService.findPostById(id);
            if (accountId == post.getAuthorId()) {
                if (postService.deletePostById(id) == 1) {
                    return "删除成功";
                }
                return "删除失败";
            }
        }
        if(session.getAttribute("admin") != null){
            if (postService.deletePostById(id) == 1) {
                return "删除成功";
            }
            return "删除失败";
        }
        return "没有权限";
    }

    /**
     * 更新帖子
     * @param post
     * @return
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
     * @param user
     * @return
     */
    @PostMapping(value={"/getUsersPosts"})
    public List getUsersPosts(@RequestBody User user){
        //Integer accountid = (Integer)session.getAttribute("accountId");
        Integer accountId = user.getUserAccountId();
        return postService.getUsersPosts(accountId);
    }

    /**
     * 删除当前用户的所有帖子
     * @param user
     * @return
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
     * 获取当前分区的所有帖子
     * @param id
     * @return
     */
    @PostMapping(value={"/getPostsBySetionId"})
    public List getPostsBySetionId(@RequestBody Integer id) {
        return postService.getPostsBySetionId(id);
    }

    /**
     * 获取当前主题下所有帖子
     * @param id
     * @return
     */
    @PostMapping(value={"/getPostsByThemeId"})
    public List getPostsByThemeId(@RequestBody Integer id){
        return postService.getPostsByThemeId(id);
    }

    /**
     * 删除当前分区下的所有帖子
     * @param id
     * @return
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
     * @param id
     * @return
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
     * @param setionId
     * @return
     */
    @PostMapping(value={"/getTopPosts"})
    public List getTopPosts(@RequestBody Integer setionId){

        return postService.getTopPosts(setionId);
    }

    /**
     * 获取精品贴
     * @param setionId
     * @return
     */
    @PostMapping(value={"/getBoutiquePosts"})
    public List getBoutiquePosts(@RequestBody Integer setionId){

        return postService.getBoutiquePosts(setionId);
    }

    /**
     * 获取热门贴
     * @param setionId
     * @return
     */
    @PostMapping(value={"/getHotPosts"})
    public List getHotPosts(@RequestBody Integer setionId){
        return postService.getHotPosts(setionId);
    }

}
