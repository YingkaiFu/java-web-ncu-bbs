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
    private PostMapper postDao;

    /**
     * 通过id查找贴子
     * @param id
     * @return
     */
    @Override
    public Post findPostById(Integer id){
        return postDao.selectByPrimaryKey(id);
    }

    /**
     * 获取最热贴子
     * @return
     */
    @Override
    public List findHostPosts() {

        return postDao.selectHostPosts();
    }

    /**
     * 获取最新贴
     * @return
     */
    @Override
    public List findNewestPosts() {

        return postDao.selectNewestPosts();
    }

    /**
     * 添加贴子
     * @param post
     * @return
     */
    @Override
    public int addPost(Post post) {
        if(postDao.insertSelective(post) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除贴子
     * @param id
     * @return
     */
    @Override
    public int deletePostById(Integer id){
        if(postDao.deleteByPrimaryKey(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 更新贴子
     * @param post
     * @return
     */
    @Override
    public int updatePost(Post post){
        if(postDao.updateByPrimaryKeySelective(post) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 获取当前用户所有贴子
     * @param id
     * @return
     */
    @Override
    public List getUsersPosts(Integer id){

        return postDao.selectByAuthorId(id);
    }

    /**
     * 删除当前用户所有贴子
     * @param id
     * @return
     */
    @Override
    public int deleteUsersPosts(Integer id){
        if(postDao.deleteByAuthorId(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除当前分区写的所有贴子
     * @param id
     * @return
     */
    @Override
    public int deleteBySetionId(Integer id){
        if(postDao.deleteBySetionId(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除当前主题下的所有贴子
     * @param id
     * @return
     */
    @Override
    public int deleteByThemeId(Integer id){
        if(postDao.deleteByThemeId(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 获取当前分区下的所有贴子
     * @param id
     * @return
     */
    @Override
    public List getPostsBySetionId(Integer id){

        return postDao.selectBySetionId(id);
    }

    /**
     * 获取当前主题下的所有贴子
     * @param themeId
     * @return
     */
    @Override
    public List getPostsByThemeId(Integer themeId){
        return postDao.selectByThemeId(themeId);
    }

    /**
     * 获取置顶帖
     * @param setionId
     * @return
     */
    @Override
    public List getTopPosts(Integer setionId) {
        return postDao.selectTopPosts(setionId);
    }



    /**
     * 获取热门贴
     * @param setionId
     * @return
     */
    @Override
    public List getHotPosts(Integer setionId) {
            return postDao.selectHotPosts(setionId);
    }


    /**
     * 获取精品贴
     * @param setionId
     * @return
     */
    @Override
    public List getBoutiquePosts(Integer setionId){
        return postDao.selectBoutiquePosts(setionId);
    }





}
