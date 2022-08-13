package me.whiteship.java8to11;

public class Foo {

    public static void main(String[] args) {
        //함수 내부에서 전달받은 파라미터 값을 변경해야 한다. -> Pure funtion
        //상태값에 의존한 상태
        RunSomething runSomething = new RunSomething() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                baseNumber++;
                return number + baseNumber;
            }
        };
    }

}
