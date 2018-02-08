package com.jeffreycheng.reactiveApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jeffreycheng.reactiveApp.model.User;
import com.jeffreycheng.reactiveApp.repository.UserReactiveRepository;

import reactor.core.publisher.Flux;

@Component
public class SampleDataPopulator implements CommandLineRunner
{
    @Autowired
    private UserReactiveRepository userReactiveRepository;

    @Override
    public void run(String... strings) throws Exception {

        userReactiveRepository.deleteAll();
        userReactiveRepository.saveAll(sampleUsers())
                .doOnComplete(() -> System.out.println("Count:"+userReactiveRepository.count()))
                .subscribe();
    }

    private Flux<User> sampleUsers()
    {
    	//converted to using reactive object instead of non-reactive List
    	return Flux.just(
			new User("uid1", "Admin",  "admin@gmail.com"),
            new User("uid2", "Siva",  "siva@gmail.com"),
            new User("uid3", "Bernard",  "bernard@gmail.com"),
            new User("uid4", "John",  "john@gmail.com"),
            new User("uid5", "Mike",  "mike@gmail.com")
		);
    	
    	/*return Arrays.asList(
                new User("uid1", "Admin",  "admin@gmail.com"),
                new User("uid2", "Siva",  "siva@gmail.com"),
                new User("uid3", "Bernard",  "bernard@gmail.com"),
                new User("uid4", "John",  "john@gmail.com"),
                new User("uid5", "Mike",  "mike@gmail.com")
        );*/
    }
}
