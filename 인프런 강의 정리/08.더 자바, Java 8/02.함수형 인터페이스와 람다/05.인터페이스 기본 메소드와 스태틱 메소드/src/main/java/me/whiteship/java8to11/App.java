package me.whiteship.java8to11;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("sangmoon");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything(); //스태틱메서드 사용

    }}
