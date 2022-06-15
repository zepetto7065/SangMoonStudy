package calculator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SplitTest {

    @Test
    public void split(){
        //내부 동작을 확인해서 학습 목적으로 테스트를 추가할수 있다.
        String[] values = "1".split(",");
        assertArrayEquals(new String[]{"1"}, values);

        values = "1,2".split(",");
        assertArrayEquals(new String[]{"1","2"}, values);
    }
}
