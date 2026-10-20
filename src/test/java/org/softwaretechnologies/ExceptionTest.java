package org.softwaretechnologies;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"UnusedAssignment", "CaughtExceptionImmediatelyRethrown"})
public class ExceptionTest {
    @Test
    public void test1() {
        int x = 1000;
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            x += 1;
        } catch (Exception e) {
            x += 20;
        } finally {
            x += 300;
        }
        assertEquals(1301, x);
    }

    @Test
    public void test2() {
        int x = 1000;
        try {
            throw new NullPointerException();
        } catch (NullPointerException  e) {
            x += 2;
        } catch (Exception e) {
            x += 10;
        }
        assertEquals(1002, x);
    }

    @Test
    public void test3() {
        int x = 0;
        try {
            throw new FileNotFoundException();
        } catch (RuntimeException e) {
            x = 1;
        } catch (Exception e) {
            x = 2;
        }
        assertEquals(2, x);
    }

    @Test
    public void test4() {
        int x = 0;
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            x = 1;
        } catch (Exception e) {
            x = 2;
        }
        assertEquals(1, x);
    }

    @Test
    public void test5() {
        int x = 0;
        try {
            try {
                throw new Exception();
            } catch (Exception e) {
                x += 10;
            }
        } catch (NullPointerException e) {
            x += 200;
        } catch (Exception e) {
            x += 3000;
        } finally {
            x += 400;
        }
        assertEquals(410, x);
    }

    String s = "";
    void f() throws Exception {
        try {
            s += "a";
            throw new Exception();
        } catch (Exception e) {
            throw e;
        } finally {
            s += "b";
        }
    }

    @Test
    public void test6() {
        try {
            f();
        } catch (Exception e) {
            s += "c";
        }
        assertEquals("abc", s);
    }
}
