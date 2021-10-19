package com.example.demo.service.impl;

import com.example.demo.entity.FullName;
import com.example.demo.repo.FullNameRepo;
import com.example.demo.service.FullNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {

    @Autowired
    private FullNameRepo repo;

    @Override
    public FullName getListOfFullNames(long accountNumber) {
       return repo.getFullNames().stream()
                .filter(element -> element.getAccountNumber() == accountNumber).findFirst().get();
    }
}
