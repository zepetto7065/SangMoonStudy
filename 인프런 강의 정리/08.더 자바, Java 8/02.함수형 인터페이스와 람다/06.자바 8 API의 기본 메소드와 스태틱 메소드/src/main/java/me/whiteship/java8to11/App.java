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
        name.forEach(System.out::println);
        System.out.println("=================");

        //spliterator
        //쪼갤수 있는 기능이 있는 iterator
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        //전부다 순회하면서 출력, 순서가 중요하지 않을 떄
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=================");
        while(spliterator1.tryAdvance(System.out::println));

        //이런식으로 stream 사용 가능.
        name.stream().map(String::toUpperCase)
                    .filter(s -> s.startsWith("s"))//K로 시작하는 걸 남기고
                    .collect(Collectors.toSet());
        System.out.println("=================");

        name.removeIf(s -> s.startsWith("s"));
        name.forEach(System.out::println);
        System.out.println("=================");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);

        System.out.println("=================");
        

    }
}
