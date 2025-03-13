package com.bakeet.aop.repository;

import com.bakeet.aop.model.Account;

import java.util.List;

public interface AccountRepository {

    void createAccount(Account account, boolean vipFlag);
    boolean isAccountActive();
    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);
    List<Account> findAccounts();

    List<Account> findAccounts(boolean vipFlag);
}
