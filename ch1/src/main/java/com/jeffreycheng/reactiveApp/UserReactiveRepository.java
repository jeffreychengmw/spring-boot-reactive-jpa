package com.jeffreycheng.reactiveApp;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserReactiveRepository extends ReactiveCrudRepository<User, String> {
}
