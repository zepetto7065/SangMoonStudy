package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator cal;

    @Before
    public void setUp(){
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_숫자하나(){
        assertEquals(3, cal.add("3"));
    }

    @Test
    public void add_쉼표구분자(){
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자(){
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자(){
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    //exception 속성을 사용해서 exception 기대할수 있다.
    @Test(expected = RuntimeException.class)
    public void add_negative() {
        cal.add("-1,2,3");
    }

}