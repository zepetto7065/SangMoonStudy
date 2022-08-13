package me.whiteship.java8to11;

@FunctionalInterface //선언해주고 위반을 하면 컴파일 에러가 난다. 인터페이스를 조금 더 견고히 관리가 가능.
public interface RunSomething {

    //추상 메서드를 딱 하나만 가지고 있음
    void doIt();



}
