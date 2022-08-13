package jpabook.jpashop;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class euckrTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "ÇÑ±Û";
        
        byte[] b = s.getBytes();
        System.out.println(s.getBytes().length);

        for(byte c : b){
            System.out.println(c);
        }


    }



}
