import com.xunfos.springrsocketkotlinmodule.controller.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.messaging.rsocket.retrieveFlow

runBlocking {
    val requester = RSocketRequester
        .builder()
        .connectTcp("localhost", 7000)
        .block()

    val tail: Flow<Transaction> = requester?.route("tail")?.retrieveFlow<Transaction>() ?: error("caboom")

    tail.collect { value ->
        println(value)
    }
}
