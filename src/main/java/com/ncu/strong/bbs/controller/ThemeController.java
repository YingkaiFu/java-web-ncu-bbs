package com.ncu.strong.bbs.controller;


import com.ncu.strong.bbs.dto.ResponseData;
import com.ncu.strong.bbs.po.Post;
import com.ncu.strong.bbs.po.Theme;
import com.ncu.strong.bbs.service.PostService;
import com.ncu.strong.bbs.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value={"/theme"})
public class ThemeController {
    private final PostService postService;

    private final ThemeService themeService;

    @Autowired
    public ThemeController(PostService postService, ThemeService themeService) {
        this.postService = postService;
        this.themeService = themeService;
    }

    /**
     * 获取所有主题
     * @return
     */
    @GetMapping(value={"/findAllThemes"})
    public List findAllThemes(){
        return themeService.findAllThemes();
    }

    /**
     * 获取某个用户的所有主题
     * @param userId
     * @return
     */
    @PostMapping(value={"/getUsersThemes"})
    public List getUsersThemes(@RequestBody Integer userId){
        return themeService.getUsersThemes(userId);
    }

    /**
     * 通过id号获取主题
     * @param id
     * @return
     */
    @PostMapping(value={"/getThemeById"})
    public Theme getThemeById(@RequestBody Integer id){
        return themeService.getThemeById(id);
    }

    /**
     * 通过分区ID获取某个分区下的所有主题
     */
    @PostMapping(value={"/getThemesBySetion"})
    public List getThemesBySetion(@RequestBody Integer setionId){
        return themeService.getThemesBySetionId(setionId);
    }

    /**
     * 删除主题
     */
    @PostMapping(value={"/deleteById"})
    public String deleteById(@RequestBody Integer id, HttpSession session){
        if(session.getAttribute("accountId") != null) {
            Integer accountId = (Integer)session.getAttribute("accountId");
            Theme theme = themeService.getThemeById(id);
            if(accountId == theme.getAuthorAccountId()) {
                if (themeService.deleteById(id) == 1) {
                    return "删除成功";
                }
                return "删除失败";
            }
        }
        if(session.getAttribute("admin") != null){
            if (themeService.deleteById(id) == 1) {
                return "删除成功";
            }
            return "删除失败";
        }
        return "没有权限";
    }

    /**
     * 删除某个用户的所有主题
     */
    @PostMapping(value={"/deleteByUserId"})
    public String deleteByUserId(@RequestBody Integer userId, HttpSession session){
        if(session.getAttribute("accountId") != null) {
           Integer accountId = (Integer)session.getAttribute("accountId");
            if(accountId == userId) {
                if (themeService.deleteUsersPosts(userId) == 1) {
                    return "删除成功";
                }
                return "删除失败";
            }
        }
        else if(session.getAttribute("admin") != null){
            if(themeService.deleteUsersPosts(userId) == 1){
                return "删除成功";
            }
            return "删除失败";
        }
        return "没有权限";
    }

    /**
     * 删除当前分区下的所有主题
     */
    @PostMapping(value={"/deleteBySetion"})
    public String deleteBySetion(@RequestBody Integer setionId, HttpSession session){
        if(session.getAttribute("admin") != null) {
            if (themeService.deleteBySetionId(setionId) == 1) {
                return "删除成功";
            }
            return "删除失败";
        }
        return "没有权限";
    }

    /**
     * 更新主题
     */
    @PostMapping(value={"/updateTheme"})
    public String updateTheme(@RequestBody Theme theme, HttpSession session){
        if(session.getAttribute("accountId") != null) {
            if (themeService.update(theme) == 1) {
                return "更改成功";
            }
            return "更改失败";
        }
        return "没有权限";
    }

    /**
     * 添加主题
     */
    @PostMapping(value={"/insert"})
    public ResponseData insert(@RequestBody Map<String, Object> data){
        System.out.println("data => " + data.toString());
        ResponseData responseData = new ResponseData();

        // 组装主题
        Theme theme = new Theme();
        theme.setTitle((String) data.get("title"));
        theme.setSetionId(Integer.parseInt((String) data.get("setionId")));
        theme.setAuthorAccountId((Integer) data.get("authorAccountId"));

        // if(session.getAttribute("account") != null) {
        if (themeService.insertTheme(theme) == 1) {
            System.out.println("theme => " + theme);
            int postThemeId = theme.getId();

            Post post = new Post();
            post.setSetionId(theme.getSetionId());
            post.setPostThemeId(postThemeId);
            post.setContent((String) data.get("content"));
            post.setAuthorId((Integer) data.get("authorAccountId"));

            if (postService.addPost(post) > 0) {
                responseData.setCode(1);
                responseData.setMsg("添加成功");
            } else {
                responseData.setCode(0);
                responseData.setMsg("添加失败");
            }
        } else {
            responseData.setCode(0);
            responseData.setMsg("添加失败");
        }
        /*} else {
            responseData.setCode(0);
            responseData.setMsg("用户未登录");
        }*/

        return responseData;
    }
}