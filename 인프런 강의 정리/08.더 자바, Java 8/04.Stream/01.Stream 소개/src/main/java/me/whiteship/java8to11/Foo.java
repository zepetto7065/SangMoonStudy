package me.whiteship.java8to11;

public interface Foo  {

    void printName();

    /**
     * @implSpec
     * 나중에 나온 기능을 추가하여 개선할 수 있다.
     * 하지만 getName()이 null이라면 문제가 된다.. 그러한 문제를 방지하기 위해 문서화를 잘하자.
     * ex) 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }


    String getName();

    static void printAnything(){
        System.out.println("Foo");
    }
}
