package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.po.Theme;

import java.util.List;

public interface ThemeService {

    /**
     * 获取所有主题
     */
    List<Theme> findAllThemes();

    /**
     * 获取用户的所有主题
     */
    List<Theme> getUsersThemes(Integer userId);

    /**
     * 通过id获取主题
     */
    Theme getThemeById(Integer id);

    /**
     * 获取当前分区下的所有主题
     */
    List<Theme> getThemesBySetionId(Integer setionId);

    /**
     * 删除贴子
     */
    int deleteById(Integer id);

    /**
     * 删除当前用户的所有主题
     */
    int deleteUsersPosts(Integer userAccountId);

    /**
     * 删除分区下的所有主题
     */
    int deleteBySetionId(Integer setionId);

    /**
     * 添加主题
     */
    int insertTheme(Theme theme);

    /**
     * 更新主题
     */
    int update(Theme theme);
}