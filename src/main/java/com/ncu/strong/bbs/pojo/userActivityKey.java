package com.ncu.strong.bbs.pojo;

public class userActivityKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.user_account_id
     *
     * @mbggenerated
     */
    private Integer userAccountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.activity_id
     *
     * @mbggenerated
     */
    private Integer activityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.user_account_id
     *
     * @return the value of user_activity.user_account_id
     *
     * @mbggenerated
     */
    public Integer getUserAccountId() {
        return userAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.user_account_id
     *
     * @param userAccountId the value for user_activity.user_account_id
     *
     * @mbggenerated
     */
    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.activity_id
     *
     * @return the value of user_activity.activity_id
     *
     * @mbggenerated
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.activity_id
     *
     * @param activityId the value for user_activity.activity_id
     *
     * @mbggenerated
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}