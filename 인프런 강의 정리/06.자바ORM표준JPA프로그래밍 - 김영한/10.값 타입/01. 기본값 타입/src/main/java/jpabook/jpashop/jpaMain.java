package jpabook.jpashop;

import javax.persistence.*;

import jpabook.jpashop.domain.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class jpaMain
{
    public static void main(String[] args) {

        Integer a = new Integer(10);
        Integer b = a;
        a.setValue(20);

//        int a = 10;
//        int b = a;

//        a = 20; //a와 b의 저장공간이 다르다.

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

}
