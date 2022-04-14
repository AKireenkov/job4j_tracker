package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactTest {
    @Test
    public void when4ThenFactorial25() {
        int number = 4;
        int rsl = 24;
        int expected = new Fact().calc(number);
        assertThat(rsl, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinus1ThenError() {
        int number = -1;
        int expected = new Fact().calc(number);
    }
}