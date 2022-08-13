package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator c;

    @Before
    public void init() {
        c = new Calculator();
    }

    @Test
    public void addTest() {
        int a = 1;
        int b = 2;

        int ret = c.add(a, b);

        assertEquals(a + b, ret);
    }

    @Test
    public void minusTest() {
        int a = 2;
        int b = 1;

        int ret = c.minus(a, b);

        assertEquals(a - b, ret);
    }

    @Test
    public void multipleTest() {
        int a = 2;
        int b = 1;

        int ret = c.multiple(a, b);

        assertEquals(a * b, ret);
    }

    @Test
    public void divideTest() {
        int a = 2;
        int b = 1;

        int ret = c.divide(a, b);

        assertEquals(a / b, ret);
    }


}