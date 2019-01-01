package com.ncu.strong.bbs.po;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;

    private String nickname;

    private String email;

    private Date birthday;

    private Integer gender;

    private String avatar;

    private String phone;

    private Integer userAccountId;

    private String motto;

    private Integer identity;

    private List<Tweet> tweets;

    private List<Question> questions;

    private List<Answer> answers;

    private List<Activity> create;

    private List<Activity> enter;

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", userAccountId=" + userAccountId +
                ", motto='" + motto + '\'' +
                ", identity=" + identity +
                ", tweets=" + tweets +
                ", questions=" + questions +
                ", answers=" + answers +
                ", created=" + create +
                ", joined=" + enter +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Activity> getCreate() {
        return create;
    }

    public void setCreate(List<Activity> create) {
        this.create = create;
    }

    public List<Activity> getEnter() {
        return enter;
    }

    public void setEnter(List<Activity> enter) {
        this.enter = enter;
    }
}