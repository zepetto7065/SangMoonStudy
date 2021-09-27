package me.zepetto.inflearnthejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class junit_9 {

    //테스트를 반복
    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10 , name = "{displayName}, {currentRepetition}/{totalRepetitions}") //반복 횟수 및 네이
    @ValueSource(ints = {10,20,40})
    @EmptySource //비어있는것을 넣어주고
    @NullSource //Null을 넣어주고
    void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name="{index} {displayName} message = {0}") //junit5는 기본으로 제공
    @ValueSource(ints = {10,20,40})
    @CsvSource({""})
    void paramiterizedTest(Study study){
        System.out.println(study.getLimit()); //각 메세지에 따라서 순서대로 출력
    }





}