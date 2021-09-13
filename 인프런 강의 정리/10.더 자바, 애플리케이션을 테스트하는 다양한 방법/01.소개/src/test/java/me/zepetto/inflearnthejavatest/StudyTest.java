package me.zepetto.inflearnthejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    // junit5부터 클래스나 테스트 메소드가 public일 필요가 없음.
    // 자바의 리플렉션.
    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled //테스트를 실행하고 싶지 않을때
    void create1(){
        System.out.println("create1");
    }

    //static void 사용해주자
    @BeforeAll
    static void beforeAll(){
        System.out.println("before All");

    }


    @AfterAll
    static void afterAll(){
        System.out.println("after All");

    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each");
    }




}