package com.bakeet.aop.repository.impl;

import com.bakeet.aop.model.Account;
import com.bakeet.aop.repository.AccountRepository;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private String name;
    private String serviceCode;



    @Override
    public void createAccount(Account account, boolean vipFlag) {
        System.out.println(getClass().getName() + ": creating account");
    }

    @Override
    public boolean isAccountActive() {
        System.out.println(getClass().getName() + ": Account is Active");
        return true;
    }

    public String getName() {
        System.out.println(getClass().getName() + ": getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getName() + ": setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass().getName() + ": getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass().getName() + ": setServiceCode");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean vipFlag) {
        if(vipFlag){
            throw new RuntimeException("Vip flag is not supported");
        }
        Faker faker = new Faker();
        List<Account> accounts = new ArrayList<Account>();
        Account account1 = new Account(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress()
        );
        Account account2 = new Account(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress()
        );
        Account account3 = new Account(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress()
        );
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }
}
