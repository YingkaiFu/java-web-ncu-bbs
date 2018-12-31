package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.AccountMapper;
import com.ncu.strong.bbs.pojo.Account;
import com.ncu.strong.bbs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountDao;


    /**
     * 登陆
     * @param loginName
     * @return
     */
    @Override
    public Account getAccountByLoginName(String loginName) {
        return accountDao.selectByLoginName(loginName);
    }

    /**
     * 注册
     * @param account
     * @return
     */
    @Override
    public int insertAccount(Account account){
        if(accountDao.insert(account) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 更改密码
     * @param account
     * @return
     */
    @Override
    public int updateAccount(Account account){
        if(accountDao.updatePasswordById(account) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 找回密码
     */
    @Override
    public int findPassword(Account account){
        if(accountDao.updatePasswordByLoginName(account) == 1){
            return 1;
        }
        return 0;
    }
}
