package com.example.demo.service.impl;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.entity.AccountBalance;
import com.example.demo.repo.AccountBalanceRepo;
import com.example.demo.service.AccountBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountBalanceRepo balanceRepo;

    @Override
    public AccountBalanceDTO getListOfAccountBalances(long accountNumber) {
        List<AccountBalance> repoResult = balanceRepo.getAccountBalances().stream()
                .filter(element -> element.getAccountNumber() == accountNumber)
                .collect(Collectors.toList());

        AccountBalanceDTO accountBalanceDTO = new AccountBalanceDTO();
        accountBalanceDTO.setBalance(repoResult.get(0).getBalance());
        accountBalanceDTO.setBlockAmount(repoResult.get(0).getBlockAmount());
        accountBalanceDTO.setHoldAmount(repoResult.get(0).getHoldAmount());

        return accountBalanceDTO;
    }
}
