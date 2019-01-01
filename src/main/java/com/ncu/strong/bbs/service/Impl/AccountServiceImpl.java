package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.AccountMapper;
import com.ncu.strong.bbs.po.Account;
import com.ncu.strong.bbs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 登陆
     */
    @Override
    public Account getAccountByLoginName(String loginName) {
        return accountMapper.selectByLoginName(loginName);
    }

    /**
     * 注册
     */
    @Override
    public int insertAccount(Account account){
        return accountMapper.insertAccount(account);
    }

    /**
     * 更改密码
     */
    @Override
    public int updateAccount(Account account){
        return accountMapper.updatePasswordById(account);
    }

    /**
     * 找回密码
     */
    @Override
    public int findPassword(Account account){
        return accountMapper.updatePasswordByLoginName(account);
    }
}