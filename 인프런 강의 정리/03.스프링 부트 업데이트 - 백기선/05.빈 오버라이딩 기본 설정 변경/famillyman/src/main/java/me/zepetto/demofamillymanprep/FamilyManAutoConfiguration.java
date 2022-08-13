package me.zepetto.demofamillymanprep;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FamilyManAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean //오버라이딩이 일어나지 않도록, 자동 설정을 제공하는 쪽에 어노테이션 활용
    public FamilyMan familyMan(){
        FamilyMan familyMan = new FamilyMan();
        familyMan.setName("whiteship");
        return familyMan;
    }
}
