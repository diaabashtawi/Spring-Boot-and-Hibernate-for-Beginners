package com.bakeet.aop.repository.impl;

import com.bakeet.aop.repository.AccountRepository;
import com.bakeet.aop.repository.MembershipRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipRepositoryImpl implements MembershipRepository {


    @Override
    public void createAccount() {
        System.out.println(getClass().getName() + ": creating membership account");
    }

    @Override
    public boolean isMembershipValid() {
        System.out.println(getClass().getName() + ": is membership valid");
        return true;
    }
}
