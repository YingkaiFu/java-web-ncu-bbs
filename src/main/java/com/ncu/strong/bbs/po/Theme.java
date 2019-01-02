package com.ncu.strong.bbs.po;

import java.util.Date;

public class Theme {
    private Integer id;

    private String title;

    private Integer setionId;

    private Integer authorAccountId;

    private Date createTime;

    private Date latestTime;

    private String nickname;

    private String avatar;

    private String replyNum;

    public Theme() {}

    @Override
    public String toString() {
        return "Theme{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", setionId=" + setionId +
            ", authorAccountId=" + authorAccountId +
            ", createTime=" + createTime +
            ", latestTime=" + latestTime +
            ", nickname='" + nickname + '\'' +
            ", avatar='" + avatar + '\'' +
            ", replyNum='" + replyNum + '\'' +
            '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSetionId() {
        return setionId;
    }

    public void setSetionId(Integer setionId) {
        this.setionId = setionId;
    }

    public Integer getAuthorAccountId() {
        return authorAccountId;
    }

    public void setAuthorAccountId(Integer authorAccountId) {
        this.authorAccountId = authorAccountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }
}