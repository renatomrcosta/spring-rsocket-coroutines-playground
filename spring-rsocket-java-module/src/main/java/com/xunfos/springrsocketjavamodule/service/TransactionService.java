package com.xunfos.springrsocketjavamodule.service;

import com.xunfos.springrsocketjavamodule.model.Transaction;
import com.xunfos.springrsocketjavamodule.model.TransactionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    public Transaction lastTransaction() {
        return new Transaction(TransactionType.Takeout, 13.2, "Huzur Kebab");
    }

    public Transaction randomTransaction() {
        return new Transaction(TransactionType.Takeout, 13.2, "Huzur Kebab");
    }

    public List<Transaction> getCurrentTransactions() {
        List<Transaction> lst = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lst.add(randomTransaction());
        }
        return lst;
    }
}
