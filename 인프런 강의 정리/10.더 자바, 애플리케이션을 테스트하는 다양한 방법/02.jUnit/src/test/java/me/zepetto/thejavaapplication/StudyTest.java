package me.zepetto.thejavaapplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

//메서드 이름의 전략을 정해준다. @DisplayName을 권장한다.
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {


    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study2() throws IllegalAccessException {
        Study study = new Study(-10);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
                () -> assertTrue(1 < 2),
                () -> assertTrue(study.getLimit() > 0, "스터디 참석 가능 인원은 0보다 커야 한다.")
        );

        //기대값과 실제값, message 역시 적을 수 있다.3번째 파람은 supplier로 구성되어 있다
        //메세지가 여러개일 수 있기때문에 성능상 람다로 쓰는게 이점이 될 수 있다.
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
//        assertTrue(1 < 2);
//        assertTrue(study.getLimit() > 0, "스터디 참석 가능 인원은 0보다 커야 한다.");
    }


    @Test
    @DisplayName("assertException을 테스트")
    void test_assert_exception() {
        IllegalAccessException illegalAccessException = assertThrows(IllegalAccessException.class, () -> new Study(-10));
        String message = illegalAccessException.getMessage();

        assertEquals("limit은 0보다 커야한다.", message);
    }

    @Test
    @DisplayName("assertTimeout을 테스트")
    void test_assert_timeout() {
        //단점은 코드블럭이 끝날때까지 기다리기 때문에 그만큼 시간이 걸린다.
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    @DisplayName("assertTimeOutPreemptively 테스트")
    void test_assert_timeout_preemptively() {
        //더이상 기다릴 필요 없이 100ms 근처에 종료한다.
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
        //TODO ThreadLocal
        //예상치 못한 결과를 발생할수 있음.
        //Timeout을 쓰는 것이 조금더 안전할 수 있음.
    }
}