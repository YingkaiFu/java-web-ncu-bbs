package com.ncu.strong.bbs.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Activity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.registration_start_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.registration_end_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activity_start_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activity_end_time
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.locale
     *
     * @mbggenerated
     */
    private String locale;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.author_id
     *
     * @mbggenerated
     */
    private Integer authorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.status
     *
     * @mbggenerated
     */
    private Boolean status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.description
     *
     * @mbggenerated
     */
    private String description;
    /**
     * 报名数
     */
    private Integer applicantNum;
    /**
     * 活动创建者
     */
    private User creator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.id
     *
     * @return the value of activity.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.id
     *
     * @param id the value for activity.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.registration_start_time
     *
     * @return the value of activity.registration_start_time
     *
     * @mbggenerated
     */
    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.registration_start_time
     *
     * @param registrationStartTime the value for activity.registration_start_time
     *
     * @mbggenerated
     */
    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.registration_end_time
     *
     * @return the value of activity.registration_end_time
     *
     * @mbggenerated
     */
    public Date getRegistrationEndTime() {
        return registrationEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.registration_end_time
     *
     * @param registrationEndTime the value for activity.registration_end_time
     *
     * @mbggenerated
     */
    public void setRegistrationEndTime(Date registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activity_start_time
     *
     * @return the value of activity.activity_start_time
     *
     * @mbggenerated
     */
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activity_start_time
     *
     * @param activityStartTime the value for activity.activity_start_time
     *
     * @mbggenerated
     */
    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activity_end_time
     *
     * @return the value of activity.activity_end_time
     *
     * @mbggenerated
     */
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activity_end_time
     *
     * @param activityEndTime the value for activity.activity_end_time
     *
     * @mbggenerated
     */
    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.locale
     *
     * @return the value of activity.locale
     *
     * @mbggenerated
     */
    public String getLocale() {
        return locale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.locale
     *
     * @param locale the value for activity.locale
     *
     * @mbggenerated
     */
    public void setLocale(String locale) {
        this.locale = locale == null ? null : locale.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.author_id
     *
     * @return the value of activity.author_id
     *
     * @mbggenerated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.author_id
     *
     * @param authorId the value for activity.author_id
     *
     * @mbggenerated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.status
     *
     * @return the value of activity.status
     *
     * @mbggenerated
     */
    public Boolean getStatus() {
        return status;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.status
     *
     * @param status the value for activity.status
     *
     * @mbggenerated
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.description
     *
     * @return the value of activity.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.description
     *
     * @param description the value for activity.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public User getCreater() {
        return creator;
    }

    public void setCreater(User creater) {
        this.creator = creater;
    }

    public Integer getApplicantNum() {
        return applicantNum;
    }

    public void setApplicantNum(Integer applicantNum) {
        this.applicantNum = applicantNum;
    }
}