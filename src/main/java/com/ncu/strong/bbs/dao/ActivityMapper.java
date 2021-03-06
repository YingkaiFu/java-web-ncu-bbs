package com.ncu.strong.bbs.dao;

import com.ncu.strong.bbs.po.Activity;

import java.util.List;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    Activity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Activity record);

    /**
     * 查询某一具体活动、创建者昵称和头像、报名数量
     * @param id
     * @return
     */
    Activity getActivity(Integer id);

    /**
     * 查询最热活动
     * @return
     */
    List getHostActivity();

    /**
     * 查询最新活动
     * @return
     */
    List getLatestActivity();
}