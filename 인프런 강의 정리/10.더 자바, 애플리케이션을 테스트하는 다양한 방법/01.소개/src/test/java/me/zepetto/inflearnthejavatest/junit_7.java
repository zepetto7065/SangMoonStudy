package me.zepetto.inflearnthejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class junit_7 {

    //커스텀 태그
    //커스텀한 어노테이션을 만들떄, 메타에노테이션을 사용할수 있다..

    @FastTest //@Tag("fast") 는 문자열이기 때문에 언제든지 오타가 날수 있다.
    @DisplayName("스터디 만들기 fast")
    void create_new(){
        //local에서 테스트를 하고...
        System.out.println("fast");
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_slow(){
        System.out.println("slow");
    }



}