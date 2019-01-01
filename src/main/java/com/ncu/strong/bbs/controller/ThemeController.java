package com.ncu.strong.bbs.controller;


import com.ncu.strong.bbs.po.Theme;
import com.ncu.strong.bbs.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value={"/theme"})
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private HttpSession session;
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
     * 获取当前分区下的所有主提
     * @param setionId
     * @return
     */
    @PostMapping(value={"/getThemesBySetion"})
    public List getThemesBySetion(@RequestBody Integer setionId){
        return themeService.getThemesBySetionId(setionId);
    }

    /**
     * 删除主题
     * @param id
     * @return
     */
    @PostMapping(value={"/deleteById"})
    public String deleteById(@RequestBody Integer id){
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
     * @param userId
     * @return
     */
    @PostMapping(value={"/deleteByUserId"})
    public String deleteByUserId(@RequestBody Integer userId){
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
     * @param setionId
     * @return
     */
    @PostMapping(value={"/deleteBySetion"})
    public String deleteBySetion(@RequestBody Integer setionId){
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
     * @param theme
     * @return
     */
    @PostMapping(value={"/updateTheme"})
    public String updateTheme(@RequestBody Theme theme){
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
     * @param theme
     * @return
     */
    @PostMapping(value={"/insert"})
    public String insert(@RequestBody Theme theme){
        Integer authorId = 0;
        String title = "";
        Theme theme1 = themeService.getThemeById(theme.getId());
        if(theme1 != null) {
            authorId = theme1.getAuthorAccountId();
            title = theme1.getTitle();
        }
        if(authorId == theme.getAuthorAccountId() && title.equals(theme.getTitle())){
            return "你已经发布过该主题";
        }
        if(themeService.insert(theme) == 1){
            return "添加成功";
        }
        return "添加失败";
    }
}