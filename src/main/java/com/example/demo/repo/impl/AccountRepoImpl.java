package com.example.demo.repo.impl;

import com.example.demo.entity.Account;
import com.example.demo.repo.AccountRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepoImpl implements AccountRepo {

    private final List<Account> accounts = new ArrayList<>();

    {
        accounts.add(new Account(2620123L, "00020", "Short Name", "type One"));
        accounts.add(new Account(2620121L, "00020", "Short Name", "type One"));
        accounts.add(new Account(2620122L, "00020", "Short Name", "type One"));
        accounts.add(new Account(2620124L, "00021", "Short Name", "type Two"));
        accounts.add(new Account(2620125L, "00022", "Short Name", "type Three"));
        accounts.add(new Account(2620126L, "00023", "Short Name", "type Four"));
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }
}
