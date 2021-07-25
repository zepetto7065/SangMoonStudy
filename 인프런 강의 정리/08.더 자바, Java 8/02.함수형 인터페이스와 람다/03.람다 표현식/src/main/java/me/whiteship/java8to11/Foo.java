package me.whiteship.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        //파라미터 인자 없음
        Supplier<Integer> get10 = () -> 10;

        //인자 2개 이상
        //타입은 변수선언부에 있기 때문에 굳이 정의하지 않아도됨.
        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b;

        //변수캡처
        Foo foo = new Foo();
        foo.run();


        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
    }

    private void run() {
        //java8부터는 변수가 사실상 final인 경우
        //사실상(effective) final? 변수를 어디서도 변경하지 않는 경우
        //아래 셋 다 모두 참조 가능
        int baseNumber = 10;

        //LocalClass
        class LocalClass {
            void printBaseNUmber() {
                int baseNumber = 11;
                System.out.println(baseNumber); //11
            }
        }

        //익명 anonymouns 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        //람다, 로컬variable 참조->아래 scope 밖에 있는 것
        //쉐도잉이 안됨 , 람다를 감싸고 있는 메서드와 스코프가 같다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);

//        baseNumber++; //effective final이 아니게 된다.
    }

}
