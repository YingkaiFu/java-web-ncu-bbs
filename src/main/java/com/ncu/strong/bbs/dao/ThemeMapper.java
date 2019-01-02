package com.ncu.strong.bbs.dao;

import com.ncu.strong.bbs.po.Theme;

import java.util.List;

public interface ThemeMapper {
    int deleteByPrimaryKey(Integer id);

    int insertTheme(Theme theme);

    List<Theme> selectAllThemes();

    List<Theme> selectUsersThemes(Integer userId);

    List<Theme> selectBySetionId(Integer setionId);

    int deleteById(Integer id);

    int deleteByUserAccountId(Integer userId);

    int deleteBySetionId(Integer setionId);

    Theme selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Theme record);

    int updateByPrimaryKey(Theme record);
}