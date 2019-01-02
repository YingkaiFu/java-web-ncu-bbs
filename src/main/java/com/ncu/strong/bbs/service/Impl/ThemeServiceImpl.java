package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.ThemeMapper;
import com.ncu.strong.bbs.po.Theme;
import com.ncu.strong.bbs.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    private final ThemeMapper themeMapper;

    @Autowired
    public ThemeServiceImpl(ThemeMapper themeMapper) {
        this.themeMapper = themeMapper;
    }

    /**
     * 获取所有主题
     */
    @Override
    public List<Theme> findAllThemes() {
        return themeMapper.selectAllThemes();
    }

    /**
     * 获取当前用户的所有主题
     */
    @Override
    public List<Theme> getUsersThemes(Integer userId) {
        return themeMapper.selectUsersThemes(userId);
    }

    /**
     * 通过id获取主题
     */
    @Override
    public Theme getThemeById(Integer id) {
       return themeMapper.selectByPrimaryKey(id);
    }


    /**
     * 获取当前分区下的所有主题
     */
    @Override
    public List<Theme> getThemesBySetionId(Integer setionId) {
        return themeMapper.selectBySetionId(setionId);
    }

    /**
     * 通过id删除主题
     */
    @Override
    public int deleteById(Integer id) {
        return themeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除当前用户的所有主题
     */
    @Override
    public int deleteUsersPosts(Integer id) {
        return themeMapper.deleteByUserAccountId(id);
    }

    /**
     * 删除当前分区下的所有主题
     */
    @Override
    public int deleteBySetionId(Integer setionId) {
        return themeMapper.deleteBySetionId(setionId);
    }

    /**
     * 添加帖子主题
     */
    @Override
    public int insertTheme(Theme theme) {
        return themeMapper.insertTheme(theme);
    }

    /**
     * 更新主题
     */
    @Override
    public int update(Theme theme) {
       return themeMapper.updateByPrimaryKeySelective(theme);
    }
}