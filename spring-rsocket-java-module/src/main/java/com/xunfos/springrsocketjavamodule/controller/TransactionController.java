package com.xunfos.springrsocketjavamodule.controller;

import com.xunfos.springrsocketjavamodule.model.Transaction;
import com.xunfos.springrsocketjavamodule.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
@Controller
public class TransactionController {
    private TransactionService transactionService;

    @MessageMapping("last")
    public Mono<Transaction> lastTransaction() {
        return Mono.just(transactionService.lastTransaction());
    }

    @MessageMapping("current")
    public Flux<Transaction> current() {
        final List<Transaction> transactionList = transactionService.getCurrentTransactions();

        return Flux.fromStream(transactionList.stream());
    }
}
