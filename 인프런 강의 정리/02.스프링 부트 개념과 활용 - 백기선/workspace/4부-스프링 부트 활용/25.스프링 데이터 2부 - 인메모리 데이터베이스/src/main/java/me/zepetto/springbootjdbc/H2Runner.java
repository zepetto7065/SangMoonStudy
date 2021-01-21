package me.zepetto.springbootjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //java8 try resource , 명시적으로 finally로 정리할 필요는 없다.
        try(Connection connection = dataSource.getConnection()){

            String url = connection.getMetaData().getURL();
            String userName = connection.getMetaData().getUserName();

            logger.info("connection :: " + url);
            logger.info("connection :: " + userName);

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);

        }

        jdbcTemplate.execute("INSERT INTO USER VALUES (1,'sangmoon')");


    }
}
