package me.zepetto.springbootmongo.account;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//embedded를 사용해보자 -> 의존성 추가
@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

//    @Before //test 돌떄 한번만..
//    public void beforeClass() throws Exception {
//        accountRepository.deleteAll();
//    }

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail(){
        Account account = new Account();
        account.setUsername("sangmoon");
        account.setEmail("adioson@naver.com");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println( accountRepository.findAll());
        assertThat(byId).isNotEmpty();

        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getUsername()).isEqualTo("sangmoon");

    }
}
