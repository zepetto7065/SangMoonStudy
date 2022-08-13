package me.zepetto.inflearnthejavatest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class junit_5 {

    //junit 5 조건에 따라 테스트 실행하기

    @Test
    void create_new(){
        //환경변수 환경에 따라 테스트 실행가능하다.
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("LOCAL".equalsIgnoreCase(test_env), ()->{
            //환경변수가 맞으면 해당 테스트 코드진행
            //Test()..
        });
    }

    @Test
    @EnabledOnOs(OS.MAC)    //mac에서만 테스트가능
    void create_anotation(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)    //특정 자바버전 테스트가능
    void create_anotation_jre(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL") //특정 환경변수에서
    void create_anotation_if(){

    }




}