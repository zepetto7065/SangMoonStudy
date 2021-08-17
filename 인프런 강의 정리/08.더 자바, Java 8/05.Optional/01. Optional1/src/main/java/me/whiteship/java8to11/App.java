package me.whiteship.java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", true));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Duration studyDuration = spring_boot.getProgress().getStudyDuration(); //getProgress가 null이다.
        System.out.println(studyDuration);

        //에러를 만드릭 좋은 코드, null check를 깜빡할수 있기 때문에..
        Progress progress = spring_boot.getProgress();
        if(progress != null){
            System.out.println(studyDuration);
        }

        //이러한 문제를 조금더 명시적으로 표현 가능.
        //return type으로 쓰는 것만이 권장 사항이다.

        Optional.of(10); //primitive type을 넣을 수 있지만, boxing&unboxing이 일어나 성능에 좋지 않다
        OptionalInt.of(10); //권장사항

        


    }
}
