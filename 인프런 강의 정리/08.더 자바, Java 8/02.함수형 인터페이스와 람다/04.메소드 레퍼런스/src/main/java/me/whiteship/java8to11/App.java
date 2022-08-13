package me.whiteship.java8to11;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

        Greeting greeting = new Greeting();

        /* static한 메서드를 사용하는 방법 */
        UnaryOperator<String> hi = Greeting::hi;
        UnaryOperator<String> hiInstance = greeting::hello;
        System.out.println(hiInstance.apply("sangmoon"));

        /* 입력값 o , 출력값 x */
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        /*입력값 o , 출력값 o*/
        //Supplier와 달리 참조하는 생성자가 다르다.
        Function<String, Greeting> sangmoonGreeting = Greeting::new;

        Greeting sangmoon = sangmoonGreeting.apply("sangmoon");
        System.out.println("sangmoon = " + sangmoon.getName());

        //comparator 가 함수형 메서드로 변경
        //임의의 객체의 인스턴스 메소드 참
        String[] names = {"홍길동","강감찬","이순신"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
