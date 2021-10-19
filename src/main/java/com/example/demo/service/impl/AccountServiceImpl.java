package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo repo;

    @Override
    public List<Account> getListOfAccounts(String clientNum) {
        return repo.getAccounts().stream()
                .filter(element -> element.getClientNum().equals(clientNum))
                .collect(Collectors.toList());
    }
}
