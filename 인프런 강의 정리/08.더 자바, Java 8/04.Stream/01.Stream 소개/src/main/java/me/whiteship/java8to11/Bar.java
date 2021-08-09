package me.whiteship.java8to11;

public interface Bar extends Foo {

    /*
    * 추상메서드로 선언을 해주면 Foo를 상속받아 printNameUpperCase를 제공받지 않는다
    */
//    void printNameUpperCase();



    /*
     * 구현체에 둘다 구현이 된다면?
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

}
