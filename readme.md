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

One can build a client manually, or use a command line tool such as [`rsc`](https://github.com/making/rsc) to invoke them.

# TODO 
- Implement a datasource to stream data instead of a hardcoded list of items
    -> So grows the scope. Do I wanna check out R2DBC?

- Implement the two-way subscription.
    -> Maybe. This would be dope for the joustus thingie
    
- Write integration tests
    -> Basic client implementation in the tests to call the stuff created
