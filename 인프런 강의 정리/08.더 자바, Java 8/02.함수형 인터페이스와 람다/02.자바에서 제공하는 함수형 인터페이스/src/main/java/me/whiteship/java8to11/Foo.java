package me.whiteship.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        //plus10의 결과값을 multiply2의 입력값으로
        Integer apply = plus10.andThen(multiply2).apply(2);
        System.out.println("apply = " + apply);

        //받기만 하는 Consumer
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        //리턴만 하는 Supplier
        Supplier<Integer> get10 = ()->10;
        System.out.println(get10.get());

        //True or False
        Predicate<String> startsWithTony = (s) -> s.startsWith("sangmoon");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        //입력값의 타입과 결과값의 타입이 같을 경우
        UnaryOperator<Integer> plus11 = (i) -> i+11;
    }

}
