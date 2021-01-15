package me.zepetto.springbootredis;

import me.zepetto.springbootredis.account.Account;
import me.zepetto.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("keesun", "whiteship");
        values.set("springboot","2.0");
        values.set("hello", "world");

        Account account = new Account();
        account.setEmail("whiteship@Email.com");
        account.setUsername("keesun");

        accountRepository.save(account);

        final Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());

    }



}
