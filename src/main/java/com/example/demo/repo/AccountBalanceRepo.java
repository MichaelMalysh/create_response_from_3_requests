package com.example.demo.repo;

import com.example.demo.entity.AccountBalance;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountBalanceRepo {
    List<AccountBalance> getAccountBalances();
}
