package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.po.Account;


public interface AccountService {

    /**
     * 登陆
     */
    Account getAccountByLoginName(String loginName);

    /**
     * 注册
     */
    int insertAccount(Account account);

    /**
     * 更改密码
     */
    int updateAccount(Account account);

    /**
     * 找回密码
     */
    int findPassword(Account account);
}