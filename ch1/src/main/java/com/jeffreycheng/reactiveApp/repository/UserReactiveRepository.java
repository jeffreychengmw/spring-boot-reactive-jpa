package com.jeffreycheng.reactiveApp.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.jeffreycheng.reactiveApp.model.User;

public interface UserReactiveRepository extends ReactiveCrudRepository<User, String> {
}
