package com.ncu.strong.bbs.service;
import com.ncu.strong.bbs.pojo.Theme;
import com.ncu.strong.bbs.pojo.User;

import java.util.List;

public interface ThemeService {

    /**
     * 获取所有主题
     * @return
     */
    List findAllThemes();

    /**
     * 获取用户的所有主题
     * @param userId
     * @return
     */
    List getUsersThemes(Integer userId);

    /**
     * 通过id获取主题
     * @param id
     * @return
     */
    Theme getThemeById(Integer id);

    /**
     * 获取当前分区下的所有主题
     * @param setionId
     * @return
     */
    List getThemesBySetionId(Integer setionId);

    /**
     * 删除贴子
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 删除当前用户的所有主题
     * @param userAccountId
     * @return
     */
    int deleteUsersPosts(Integer userAccountId);

    /**
     * 删除分区下的所有主题
     * @param setionId
     * @return
     */
    int deleteBySetionId(Integer setionId);

    /**
     * 添加主题
     * @param theme
     * @return
     */
    int insert(Theme theme);

    /**
     * 更新主题
     * @param theme
     * @return
     */
    int update(Theme theme);


}
