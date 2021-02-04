package jpabook.jpashop;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class utf8test {

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "한글";
        byte[] b = s.getBytes();
        System.out.println(s.getBytes().length);

        for(byte c : b){
            System.out.println(c);
        }

    }



}
