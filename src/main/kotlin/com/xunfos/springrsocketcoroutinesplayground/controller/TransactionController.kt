package com.xunfos.springrsocketcoroutinesplayground.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service


// https://www.baeldung.com/rsocket continue

enum class TransactionType {
    Shopping,
    Education,
    Takeout,
    Transport,
    Other
}

data class Transaction(val type: TransactionType, val amount: Double, val vendor: String)

@Controller
class TransactionController(
    private val transactionService: TransactionService
) {
    @MessageMapping
    fun lastTransaction() = transactionService.lastTransaction()
}

@Service
class TransactionService {
    fun lastTransaction() = Transaction(
        type = TransactionType.Takeout,
        amount = 12.3,
        vendor = "Huzur Kebab"
    )
}
