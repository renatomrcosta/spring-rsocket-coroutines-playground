# Spring RSocket Playground

Small experimentation repo to play around with Spring + RSocket, and to compare between the traditional usage in Java (with Reactor's Mono and Flux) and Kotlin (with Coroutines, yay)

# Running

Both modules are simple Spring Boot applications. Run either via

```bash
$ ./gradlew bootRun
```

The Java module is configured in port 7000

The Kotlin module is configured in port 8000

# Endpoints

Two simple message endpoints for now:

- `last` - Shows the last "transaction" that occurred in this system

- `current` tails a collection of "transactions"

# TODO

- Implement a datasource to stream data instead of a hardcoded list of items
- Implement the two-way subscription.
- Write integration tests

# Application Checklist

Business conceit: Given an arbitrary data source (database, cache or stream) that publishes real-time transaction data (representing a financial transaction, such as a purchase or bank transfer, for instance).

- Request Only
    - Registers a new transaction without waiting for the reply (aka saves it in the final data storage / publishes the event)
- Request Response
    - Request the latest transaction or a request a transaction by Id
- Request Subscription
    - Request the current tail of transactions (read only)
- Subscription Subscription
    It would be dope to have an idempotency flag that would allow the requests to process the same data locked away 
    So the worker subscribes asking the next few marked without processing, and update the status as the processing happens
        -> There is likely a race condition in the fetching, How could I mitigate this?


Application
    RSocket run on port N000
    Mongo runs on port N001
    H2 runs on port N002
    

