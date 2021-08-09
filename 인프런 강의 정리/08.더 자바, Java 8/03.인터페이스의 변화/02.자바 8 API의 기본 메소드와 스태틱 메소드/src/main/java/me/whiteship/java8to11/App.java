package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("sangmoon");
        name.add("tony");
        name.add("zepetto");
        name.add("adios");

        //forEach
        //조금 더 손쉽게 출력이 가능하다.
        name.forEach(System.out::println);
        System.out.println("=======forEach 종료==========");

        //spliterator
        //쪼갤수 있는 기능이 있는 iterator
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        //전부 다 순회하면서 출력, 순서가 중요하지 않을 때
        //없으면 false가 return
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=======절반을 나눈 후==========");
        while(spliterator1.tryAdvance(System.out::println));
        System.out.println("=================");

        name.removeIf(s -> s.startsWith("s")); //s로 시작하는 것을 빼라
        name.forEach(System.out::println);
        System.out.println("=======removeIf 종료==========");

        //정렬을 functional interface로
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        System.out.println("=======Comparator 종료==========");

        //functional interface를 사용하면서 API의 변화
        

    }
}
