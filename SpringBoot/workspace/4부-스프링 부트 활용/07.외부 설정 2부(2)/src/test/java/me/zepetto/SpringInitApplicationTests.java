package me.zepetto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest(properties = "sangmoon.name=sangmoon")
@SpringBootTest
@TestPropertySource(locations = "classpath:/test.properties")
public class SpringInitApplicationTests {

    @Autowired
    Environment environment;

    @Test
    public void contextLoads(){
        assertThat(environment.getProperty("sangmoon.fullName"))
                .isEqualTo("sangmoon2 Yoo");
    }

}


