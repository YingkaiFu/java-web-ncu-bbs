package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.PostMapper;
import com.ncu.strong.bbs.po.Post;
import com.ncu.strong.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    /**
     * 通过id查找贴子
     */
    @Override
    public Post findPostById(Integer id){
        return postMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取最热贴子
     */
    @Override
    public List findHostPosts() {
        return postMapper.selectHostPosts();
    }

    /**
     * 获取最新贴
     */
    @Override
    public List findNewestPosts() {
        return postMapper.selectNewestPosts();
    }

    /**
     * 添加贴子
     */
    @Override
    public int addPost(Post post) {
        if(postMapper.insertSelective(post) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除贴子
     */
    @Override
    public int deletePostById(Integer id){
        return postMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新贴子
     */
    @Override
    public int updatePost(Post post){
        return postMapper.updateByPrimaryKeySelective(post);
    }

    /**
     * 获取当前用户所有贴子
     */
    @Override
    public List getUsersPosts(Integer id){
        return postMapper.selectByAuthorId(id);
    }

    /**
     * 删除当前用户所有贴子
     */
    @Override
    public int deleteUsersPosts(Integer id){
        return postMapper.deleteByAuthorId(id);
    }

    /**
     * 删除当前分区写的所有贴子
     */
    @Override
    public int deleteBySetionId(Integer id){
        return postMapper.deleteBySetionId(id);
    }

    /**
     * 删除当前主题下的所有贴子
     */
    @Override
    public int deleteByThemeId(Integer id){
        return postMapper.deleteByThemeId(id);
    }

    /**
     * 获取当前分区下的所有贴子
     */
    @Override
    public List<Post> getPostsBySetionId(Integer id){
        return postMapper.selectBySetionId(id);
    }

    /**
     * 获取当前主题下的所有贴子
     */
    @Override
    public List getPostsByThemeId(Integer themeId){
        return postMapper.selectByThemeId(themeId);
    }

    /**
     * 获取置顶帖
     */
    @Override
    public List getTopPosts(Integer setionId) {
        return postMapper.selectTopPosts(setionId);
    }

    /**
     * 获取热门贴
     */
    @Override
    public List getHotPosts(Integer setionId) {
            return postMapper.selectHotPosts(setionId);
    }


    /**
     * 获取精品贴
     */
    @Override
    public List getBoutiquePosts(Integer setionId){
        return postMapper.selectBoutiquePosts(setionId);
    }
}