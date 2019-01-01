package com.ncu.strong.bbs.po;


import java.util.Objects;

public class Account {
    private Integer id;

    private String loginName;

    private String password;

    public Account() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;
        return Objects.equals(loginName, account.loginName) && Objects.equals(password, account.password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}