package me.zepetto.inflearnthejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class junit_8 {

    //테스트를 반복
    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10 , name = "{displayName}, {currentRepetition}/{totalRepetitions}") //반복 횟수 및 네이
    void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name="{index} {displayName} message = {0}") //junit5는 기본으로 제공
    @ValueSource(strings = {"날씨가","많이","추워지고","있네요"})
    void paramiterizedTest(String message){
        System.out.println(message); //각 메세지에 따라서 순서대로 출력
    }





}