package me.zepetto.inflearnthejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class junit_6 {

    //태깅과 필터링
    //우리가 만든 테스트가 여러개 있다면 테스트를 그룹화할 수 있음.


    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void create_new(){
        //local에서 테스트를 하고...
        System.out.println("fast");
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create_slow(){
        //CI 환경에서 테스트를 하고 싶을 때..
        System.out.println("slow");
    }


}