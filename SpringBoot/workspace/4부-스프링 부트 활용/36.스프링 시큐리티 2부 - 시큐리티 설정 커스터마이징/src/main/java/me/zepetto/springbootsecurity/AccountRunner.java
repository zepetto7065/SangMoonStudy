package me.zepetto.springbootsecurity;

import me.zepetto.springbootsecurity.account.Account;
import me.zepetto.springbootsecurity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {
    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Account sangmoon = accountService.createAccount("sangmoon", "1234");
        System.out.println(sangmoon.getUsername() + " password:"+sangmoon.getPassword());
    }
}
