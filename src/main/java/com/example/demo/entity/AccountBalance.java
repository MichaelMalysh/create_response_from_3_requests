package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountBalance {

    private long accountNumber;

    private int balance;

    private int blockAmount;

    private int holdAmount;
}
