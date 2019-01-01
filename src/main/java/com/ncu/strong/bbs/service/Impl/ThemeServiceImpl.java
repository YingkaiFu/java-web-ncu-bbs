package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.ThemeMapper;
import com.ncu.strong.bbs.po.Theme;
import com.ncu.strong.bbs.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeMapper themeDao;

    /**
     * 获取所有主题
     * @return
     */
    @Override
    public List findAllThemes() {
        return themeDao.selectAllThemes();
    }

    /**
     * 获取当前用户的所有主题
     * @param userId
     * @return
     */
    @Override
    public List getUsersThemes(Integer userId) {
        return themeDao.selectUsersThemes(userId);
    }

    /**
     * 通过id获取主题
     * @param id
     * @return
     */
    @Override
    public Theme getThemeById(Integer id) {
       return themeDao.selectByPrimaryKey(id);
    }


    /**
     * 获取当前分区下的所有主题
     * @param setionId
     * @return
     */
    @Override
    public List getThemesBySetionId(Integer setionId) {
        return themeDao.selectBySetionId(setionId);
    }

    /**
     * 通过id删除主题
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        if(themeDao.deleteByPrimaryKey(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除当前用户的所有主题
     * @param id
     * @return
     */
    @Override
    public int deleteUsersPosts(Integer id) {
        if(themeDao.deleteByUserAccountId(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除当前分区下的所有主题
     * @param setionId
     * @return
     */
    @Override
    public int deleteBySetionId(Integer setionId) {
        if(themeDao.deleteBySetionId(setionId) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 添加主题
     * @param theme
     * @return
     */
    @Override
    public int insert(Theme theme) {
        if(themeDao.insertSelective(theme) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 更新主题
     * @param theme
     * @return
     */
    @Override
    public int update(Theme theme) {
       if(themeDao.updateByPrimaryKeySelective(theme) == 1){
           return 1;
       }
       return 0;
    }
}
