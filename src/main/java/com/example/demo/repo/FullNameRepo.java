package com.example.demo.repo;

import com.example.demo.entity.FullName;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FullNameRepo {

    List<FullName> getFullNames();
}
