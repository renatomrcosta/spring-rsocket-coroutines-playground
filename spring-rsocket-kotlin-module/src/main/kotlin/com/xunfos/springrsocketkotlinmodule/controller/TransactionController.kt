package com.xunfos.springrsocketkotlinmodule.controller

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service

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
    @MessageMapping("last")
    fun lastTransaction() = transactionService.lastTransaction()

    @MessageMapping("current")
    suspend fun current(): Flow<Transaction> = flow {
        repeat(100) {
            delay(100)
            emit(transactionService.randomTransaction())
        }
    }
}

@Service
class TransactionService {
    fun lastTransaction() = Transaction(
        type = TransactionType.Takeout,
        amount = 12.3,
        vendor = "Huzur Kebab"
    )

    fun randomTransaction() =
        Transaction(
            type = TransactionType.Takeout,
            amount = 12.3,
            vendor = "Huzur Kebab"
        )
}
