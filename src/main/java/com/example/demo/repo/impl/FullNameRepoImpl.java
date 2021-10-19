package com.example.demo.repo.impl;

import com.example.demo.entity.FullName;
import com.example.demo.repo.FullNameRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FullNameRepoImpl implements FullNameRepo {

    List<FullName> fullNameList = new ArrayList<>();


    {
        fullNameList.add(new FullName(2620123L, "Full Name For First User"));
        fullNameList.add(new FullName(2620121L, "Full Name For Second User"));
        fullNameList.add(new FullName(2620122L, "Full Name For Third User"));
        fullNameList.add(new FullName(2620124L, "Full Name For Fourth User"));
        fullNameList.add(new FullName(2620125L, "Full Name For Fifth User"));
        fullNameList.add(new FullName(2620126L, "Full Name For Six User"));
    }
    @Override
    public List<FullName> getFullNames() {
        return fullNameList;
    }
}
