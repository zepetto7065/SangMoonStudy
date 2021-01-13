package me.zepetto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SpringRunner.class);

    @Autowired
    private String hello;

    @Autowired
    private SangmoonProperties sangmoonProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("========================");
        logger.debug(hello);
        logger.debug(sangmoonProperties.getName());
        logger.debug("========================");
    }
}
