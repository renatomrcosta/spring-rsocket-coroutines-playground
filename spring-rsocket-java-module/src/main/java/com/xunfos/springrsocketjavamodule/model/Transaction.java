package com.xunfos.springrsocketjavamodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Transaction {
    private TransactionType type;
    private Double amount;
    private String vendor;
}
