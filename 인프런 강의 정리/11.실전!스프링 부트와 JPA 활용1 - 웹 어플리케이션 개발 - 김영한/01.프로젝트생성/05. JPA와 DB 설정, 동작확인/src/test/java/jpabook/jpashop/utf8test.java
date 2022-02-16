package jpabook.jpashop;

import org.junit.Test;

public class utf8test {

    @Test
    public void test(){
        String s = "각난";
        byte[] b = s.getBytes();
        System.out.println(s.getBytes().length);

        for(byte c : b){
            System.out.println(c);
        }

    }



}
