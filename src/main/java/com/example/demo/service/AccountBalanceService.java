package com.example.demo.service;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.entity.AccountBalance;

import java.util.List;

public interface AccountBalanceService {

    AccountBalanceDTO getListOfAccountBalances(long accountBalance);
}
