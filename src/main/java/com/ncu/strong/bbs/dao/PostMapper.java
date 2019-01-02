package com.ncu.strong.bbs.dao;

import com.ncu.strong.bbs.po.Post;

import java.util.List;

public interface PostMapper {
    /**
     *通过id删除贴子
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);


    /**
     *添加贴子
     * @mbggenerated
     */
    int insertSelective(Post record);

    /**
     *通过id查找贴子
     * @mbggenerated
     */
    Post selectByPrimaryKey(Integer id);

    /**
     * 获取最热贴子
     * @return
     */
    List selectHostPosts();

    /**
     * 获取最新贴
     */
    List selectNewestPosts();

    /**
     * 查找某个用户的所有贴子
     */
    List<Post> selectByAuthorId(Integer authorId);

    /**
     * 查找某个分区的所有贴子
     */
    List<Post> selectBySetionId(Integer setionId);

    /**
     * 查找某个主题的所有贴子
     */
    List selectByThemeId(Integer themeId);

    /**
     * 查找置顶帖
     */
    List selectTopPosts(Integer setionId);

    /**
     * 查找精品贴
     */
    List selectBoutiquePosts(Integer setionId);

    /**
     * 查找最热贴
     */
    List selectHotPosts(Integer setionId);

    /**
     * 删除某个用户的所有贴子
     */
    int deleteByAuthorId(Integer authorId);

    /**
     * 删除某个分区的所有贴子
     */
    int deleteBySetionId(Integer setionId);

    /**
     * 删除某个主题的所有贴子
     */
    int deleteByThemeId(Integer themeId);

    /**
     *跟新贴子部分信息
     */
    int updateByPrimaryKeySelective(Post record);


    /**
     * 更新贴子所有信息
     */
    int updateByPrimaryKey(Post record);
}