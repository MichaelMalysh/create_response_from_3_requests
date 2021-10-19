package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountBalanceDTO {

    private int balance;

    private int blockAmount;

    private int holdAmount;
}
