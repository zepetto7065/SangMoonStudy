package jpabook.jpashop;

import org.junit.Test;
import sun.nio.cs.ext.EUC_KR;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class euckrTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "한글";

        System.out.println(s.getBytes("utf-8").toString());
        System.out.println(s.getBytes("euc-kr").toString());


    }



}
