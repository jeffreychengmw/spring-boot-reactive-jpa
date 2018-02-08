package com.jeffreycheng.reactiveApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.jeffreycheng.reactiveApp.model.User;
import com.jeffreycheng.reactiveApp.repository.UserReactiveRepository;

import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class UserListController {

    @Autowired
    private UserReactiveRepository userReactiveRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/list-users")
    public String listUsers(Model model){
        Flux<User> userFlux = this.userReactiveRepository.findAll().repeat(3000);
        List<User> userList = userFlux.collectList().block();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping("/list-users-chunked")
    public String listUsersChunked(Model model){
        Flux<User> userFlux = this.userReactiveRepository.findAll().repeat(3000);
        model.addAttribute("users", userFlux);
        return "users";
    }

    @GetMapping("/list-users-reactive")
    public String listUsersReactive(Model model){
        Flux<User> userFlux = this.userReactiveRepository.findAll().repeat(3000);
        model.addAttribute("users", new ReactiveDataDriverContextVariable(userFlux, 50));
        return "users";
    }
}
