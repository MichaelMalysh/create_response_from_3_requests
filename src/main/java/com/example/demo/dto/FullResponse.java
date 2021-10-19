package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FullResponse {

    private long accountNumber;

    private String clientNum;

    private String shortName;

    private String type;

    private String accountFullName;

    private int balance;

    private int blockAmount;

    private int holdAmount;
}
