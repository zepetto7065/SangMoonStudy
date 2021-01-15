package me.zepetto.springbootjdbc.account;

import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest ->Application 모든 Bean이 등록이 된다. 그렇기 떄문에 application.properties가 적용이 된다.
// 따라서 postgresql을 사용하게 된다. embedded db가 빠르다. 그리고 TestDB를 나눌수 있다.
// 대안으로 @SpringBootTest(properties = "spring.datasource.url=테스트용 프로퍼티")가 있으나..
// 간단하게 슬라이싱 테스트 , @DataJpaTest가 깔끔
public class AccountRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
//        try(Connection connection = dataSource.getConnection()){
//            DatabaseMetaData metaData = connection.getMetaData();
//            logger.info(metaData.getURL());
//            logger.info(metaData.getDriverName());
//            logger.info(metaData.getUserName());
//        }
        Account account = new Account();
        account.setUsername("sangmoon");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

        Optional<Account> nonExistingAccout = accountRepository.findByUsername("zepetto");
        assertThat(nonExistingAccout).isNull();

    }

}