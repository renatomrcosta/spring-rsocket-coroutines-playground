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
