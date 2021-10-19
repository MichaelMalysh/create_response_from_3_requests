package com.example.demo.repo.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountBalance;
import com.example.demo.repo.AccountBalanceRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountBalanceRepoImpl implements AccountBalanceRepo {

    private final List<AccountBalance> accountBalances = new ArrayList<>();

    {
        accountBalances.add(new AccountBalance(2620123L,22222, 0, 1));
        accountBalances.add(new AccountBalance(2620122L,22233, 0, 1));
        accountBalances.add(new AccountBalance(2620121L,22233, 0, 1));
        accountBalances.add(new AccountBalance(2620124L,33333, 1, 10));
        accountBalances.add(new AccountBalance(2620125L,44444, 0, 1));
        accountBalances.add(new AccountBalance(2620126L,55555, 1, 10));

    }

    @Override
    public List<AccountBalance> getAccountBalances() {
        return accountBalances;
    }
}
