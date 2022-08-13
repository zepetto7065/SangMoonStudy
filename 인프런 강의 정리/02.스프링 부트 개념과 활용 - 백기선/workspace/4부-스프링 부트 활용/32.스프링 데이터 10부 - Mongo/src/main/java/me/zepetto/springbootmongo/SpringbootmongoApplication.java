package me.zepetto.springbootmongo;

import me.zepetto.springbootmongo.account.Account;
import me.zepetto.springbootmongo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootmongoApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmongoApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner applicationRunner(){
//        return args -> {
//            Account account = new Account();
//            account.setEmail("adioson@naver.com");
//            account.setUsername("whiteship");
//            accountRepository.insert(account);
////            mongoTemplate.insert(account);
//            System.out.println("finished");
//
//        };
//    }

}
