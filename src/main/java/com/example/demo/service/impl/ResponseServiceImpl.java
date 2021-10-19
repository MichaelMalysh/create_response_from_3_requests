package com.example.demo.service.impl;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.dto.FullResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.FullName;
import com.example.demo.service.AccountBalanceService;
import com.example.demo.service.AccountService;
import com.example.demo.service.FullNameService;
import com.example.demo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private FullNameService fullNameService;


    private List<AccountBalanceDTO> accountBalanceDTOS = new ArrayList<>();
    private List<FullName> fullNameList = new ArrayList<>();


    @Override
    public List<FullResponse> getFullResponse() {
        return getListOfFullResponse();
    }
    /*
    accountNumber;
    clientNum;
    shortName;
    type;
    accountFullName;
    balance;
    blockAmount;
    holdAmount;
    */
    private List<FullResponse> getListOfFullResponse(){
        List<FullResponse> fullResponses;
        final List<Account> listOfAccounts = accountService.getListOfAccounts("00020");
        final List<Long> listOfAccountNumbers = getListOfAccountNumbers(listOfAccounts);

        listOfAccountNumbers.forEach(this::getListOfAccountBalance);
        listOfAccountNumbers.forEach(this::getListOfFullNames);

        fullResponses = range(0, listOfAccountNumbers.size()).mapToObj(i -> new FullResponse(listOfAccountNumbers.get(i),
                listOfAccounts.get(i).getClientNum(),
                listOfAccounts.get(i).getShortName(),
                listOfAccounts.get(i).getType(),
                fullNameList.get(i).getAccountFullName(),
                accountBalanceDTOS.get(i).getBalance(),
                accountBalanceDTOS.get(i).getBlockAmount(),
                accountBalanceDTOS.get(i).getHoldAmount()
        )).collect(Collectors.toList());

        return fullResponses;
    }

    /*
    balance;
    blockAmount;
    holdAmount;
     */
    private void getListOfAccountBalance(long accountNumber){
        final AccountBalanceDTO listOfAccountBalances = accountBalanceService.getListOfAccountBalances(accountNumber);
        accountBalanceDTOS.add(listOfAccountBalances);
    }
    /*
    accountNumber;
    accountFullName;
     */
    private void getListOfFullNames(long accountNumber){
        final FullName fullName = fullNameService.getListOfFullNames(accountNumber);
        fullNameList.add(fullName);
    }

    private List<Long> getListOfAccountNumbers(List<Account> listOfAccounts) {
        return listOfAccounts.stream()
                .map(Account::getAccountNumber)
                .collect(Collectors.toList());
    }
}
