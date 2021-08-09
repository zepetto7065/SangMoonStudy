package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("sangmoon");
        names.add("zepetto");
        names.add("tony");
        names.add("foo");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        System.out.println("======================");
        //Lazy하다..
        //종료 오퍼레이터가 오기전까지  (map)
        //중계 오퍼레이터는 실행을 안한다. (collect)
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("======================");
        //원본
        names.forEach(System.out::println);

        System.out.println("======================");
        //병렬처리가 힘들다.
        for(String name:names){
            if(name.startsWith("k")){
                System.out.println(name.toUpperCase());
            }
        }
        //parallelStream 이라고 다 빨라지는 건 아니다.
        //멀티스레드가 가장 빠르다할 수 없음.
        //단, 스레드를 만드는데에 비용이 든다. Context Switching 비용
        //유용할 때->데이터가 정말 방대하게 큰 경우
        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }
}
