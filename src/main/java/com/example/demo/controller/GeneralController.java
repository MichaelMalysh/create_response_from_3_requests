package com.example.demo.controller;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.dto.FullResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.AccountBalance;
import com.example.demo.entity.FullName;
import com.example.demo.service.AccountBalanceService;
import com.example.demo.service.AccountService;
import com.example.demo.service.FullNameService;
import com.example.demo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GeneralController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private FullNameService fullNameService;

    @Autowired
    private ResponseService responseService;

    @GetMapping("/get-accounts")
    public List<Account> getAllAccountsByClientNum(@RequestParam("clientNum") String clientNum){

        return accountService.getListOfAccounts(clientNum);
    }

    @GetMapping("/get-account-balances")
    public AccountBalanceDTO getAllAccountBalancesByAccountNumber(@RequestParam("accNum") long accNum){

        return accountBalanceService.getListOfAccountBalances(accNum);
    }

    @GetMapping("/get-full-names")
    public FullName getAllFullNamesByAccountNumber(@RequestParam("accNum") long accNum){

        return fullNameService.getListOfFullNames(accNum);
    }

    @GetMapping("/get-result")
    public List<FullResponse> getFullResponse(){

        return responseService.getFullResponse();
    }
}
