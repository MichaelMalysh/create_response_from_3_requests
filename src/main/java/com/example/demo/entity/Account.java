package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    private long accountNumber;

    private String clientNum;

    private String shortName;

    private String type;
}
