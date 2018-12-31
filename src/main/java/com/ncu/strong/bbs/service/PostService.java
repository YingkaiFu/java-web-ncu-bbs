package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.pojo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    /**
     * 通过id获取体贴子
     * @param id
     * @return
     */
    Post findPostById(Integer id);

    /**
     * 获取最热贴子
     * @return
     */
    List findHostPosts();

    /**
     * 获取最新贴
     * @return
     */
    List findNewestPosts();

    /**
     * 添加贴子
     * @param post
     * @return
     */
    int addPost(Post post);

    /**
     * 通过id删除贴子
     * @param id
     * @return
     */
    int deletePostById(Integer id);

    /**
     * 跟新贴子
     * @param post
     * @return
     */
    int updatePost(Post post);

    /**
     * 获取当前用户的所有贴子
     * @param id
     * @return
     */
    List getUsersPosts(Integer id);

    /**
     * 删除当前用户的所有贴子
     * @param id
     * @return
     */
    int deleteUsersPosts(Integer id);

    /**
     * 删除当前分区下的所有贴子
     * @param setionId
     * @return
     */
    int deleteBySetionId(Integer setionId);

    /**
     * 删除当前主题下的所有贴子
     * @param themeId
     * @return
     */
    int deleteByThemeId(Integer themeId);

    /**
     * 获取当前主题下的所有贴子
     * @param themeId
     * @return
     */
    List getPostsByThemeId(Integer themeId);

    /**
     * 获取当前分区下的所有贴子
     * @param setionId
     * @return
     */
    List getPostsBySetionId(Integer setionId);

    /**
     * 获取置顶帖
     * @param setionId
     * @return
     */
    List getTopPosts(Integer setionId);

    /**
     * 获取热门贴
     * @param setionId
     * @return
     */
    List getHotPosts(Integer setionId);

    /**
     * 获取精品贴
     * @param setionId
     * @return
     */
    List getBoutiquePosts(Integer setionId);



}
