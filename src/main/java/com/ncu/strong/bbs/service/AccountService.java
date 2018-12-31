package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.pojo.Account;
import org.springframework.stereotype.Service;


public interface AccountService {

    /**
     * 登陆
     * @param loginName
     * @return
     */
    Account getAccountByLoginName(String loginName);

    /**
     * 注册
     * @param account
     * @return
     */
    int insertAccount(Account account);

    /**
     * 更改密码
     * @param account
     * @return
     */
    int updateAccount(Account account);

    /**
     * 找回密码
     * @param account
     * @return
     */
    int findPassword(Account account);
}
