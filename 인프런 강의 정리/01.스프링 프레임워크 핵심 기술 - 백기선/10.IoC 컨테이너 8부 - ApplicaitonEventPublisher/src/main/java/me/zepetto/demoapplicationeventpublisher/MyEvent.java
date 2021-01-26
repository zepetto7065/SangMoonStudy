package me.zepetto.demoapplicationeventpublisher;

public class MyEvent{
    //비침투성
    //이 소스엔 스프링 소스 코드가 들어가지 않는다.
    //프레임워크 코드가 개발자 소스에 들어가지 않는다. 테스트가 용이하고 유지보수하기가 쉽다.

    private int data;

    private Object source;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
