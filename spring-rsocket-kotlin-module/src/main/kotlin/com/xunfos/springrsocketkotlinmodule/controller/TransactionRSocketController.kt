package com.xunfos.springrsocketkotlinmodule.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.UUID

@Controller
class TransactionRSocketController(
    private val transactionService: TransactionService
) {
    @MessageMapping("transaction")
    suspend fun getTransactionById(id: UUID): Transaction {
        val transaction: Transaction = transactionService.getTransactionById(id)
        return transaction
    }
}

@Service
class TransactionService {
    fun getTransactionById(id: UUID) =
        Transaction(UUID.randomUUID(), 123.0)

    fun listAllTransactions(): Flux<Transaction> = Flux.fromIterable(
        listOf(
            Transaction(UUID.randomUUID(), 12.0),
            Transaction(UUID.randomUUID(), 15.0),
            Transaction(UUID.randomUUID(), 16.0),
            Transaction(UUID.randomUUID(), 17.0),
            Transaction(UUID.randomUUID(), 18.0)
        )
    )
}

data class Transaction(val id: UUID, val amount: Double)
