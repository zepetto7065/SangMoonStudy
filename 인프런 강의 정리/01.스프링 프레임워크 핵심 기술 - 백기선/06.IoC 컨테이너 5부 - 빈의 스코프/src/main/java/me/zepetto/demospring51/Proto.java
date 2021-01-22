package me.zepetto.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS) // 쓰기는 쉽다. proxyMode 설정, default는
// 사용하지 않는다, TARGET_CLASS CG라이브러리(써드파티)를 사용하는 다이나믹 프록시(자바 기반의 프록시는 인터페이스만 프록시로 만들수 있다, class 레벨을 프록시를 만들기 위해서
// CG라이브러리를 사용한다
// 어렵다
// 클래스 기반의 포록시로 감싸라.왜? 싱글이 다른 인스턴스들이 프록를 거쳐서 참조해야하기 때문에 왜? 직접쓰면 바꿔줄 여지를 두지 않는다
// TARGET_CLASS 외에도 INTERFACE도 있다.
public class Proto {

    //매번 같은 인스턴스가 들어온다. 아무런 문제가 없다.
    @Autowired
    Single single;

}
