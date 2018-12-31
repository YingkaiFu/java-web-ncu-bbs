package com.ncu.strong.bbs.pojo;

import java.util.Date;

public class Post {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.reply_id
     *
     * @mbggenerated
     */
    private Integer replyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.author_id
     *
     * @mbggenerated
     */
    private Integer authorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.setion_id
     *
     * @mbggenerated
     */
    private Integer setionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.create_time
     *
     * @mbggenerated
     */


    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.mark
     *
     * @mbggenerated
     */
    private Boolean mark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.click_num
     *
     * @mbggenerated
     */
    private Integer clickNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.top
     *
     * @mbggenerated
     */
    private Boolean top;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.post_theme_id
     *
     * @mbggenerated
     */
    private Integer postThemeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post.content
     *
     * @mbggenerated
     */
    private String content;

    /*private User user;

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }*/

    private Integer replyNum;

    private String nickName;

    private String avatar;

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.id
     *
     * @return the value of post.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.id
     *
     * @param id the value for post.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.reply_id
     *
     * @return the value of post.reply_id
     *
     * @mbggenerated
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.reply_id
     *
     * @param replyId the value for post.reply_id
     *
     * @mbggenerated
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.author_id
     *
     * @return the value of post.author_id
     *
     * @mbggenerated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.author_id
     *
     * @param authorId the value for post.author_id
     *
     * @mbggenerated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.setion_id
     *
     * @return the value of post.setion_id
     *
     * @mbggenerated
     */
    public Integer getSetionId() {
        return setionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.setion_id
     *
     * @param setionId the value for post.setion_id
     *
     * @mbggenerated
     */
    public void setSetionId(Integer setionId) {
        this.setionId = setionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.create_time
     *
     * @return the value of post.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.create_time
     *
     * @param createTime the value for post.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.mark
     *
     * @return the value of post.mark
     *
     * @mbggenerated
     */
    public Boolean getMark() {
        return mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.mark
     *
     * @param mark the value for post.mark
     *
     * @mbggenerated
     */
    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.click_num
     *
     * @return the value of post.click_num
     *
     * @mbggenerated
     */
    public Integer getClickNum() {
        return clickNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.click_num
     *
     * @param clickNum the value for post.click_num
     *
     * @mbggenerated
     */
    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.top
     *
     * @return the value of post.top
     *
     * @mbggenerated
     */
    public Boolean getTop() {
        return top;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.top
     *
     * @param top the value for post.top
     *
     * @mbggenerated
     */
    public void setTop(Boolean top) {
        this.top = top;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.post_theme_id
     *
     * @return the value of post.post_theme_id
     *
     * @mbggenerated
     */
    public Integer getPostThemeId() {
        return postThemeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.post_theme_id
     *
     * @param postThemeId the value for post.post_theme_id
     *
     * @mbggenerated
     */
    public void setPostThemeId(Integer postThemeId) {
        this.postThemeId = postThemeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.update_time
     *
     * @return the value of post.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.update_time
     *
     * @param updateTime the value for post.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post.content
     *
     * @return the value of post.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post.content
     *
     * @param content the value for post.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}