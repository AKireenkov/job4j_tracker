package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionRange function = new FunctionRange();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        FunctionRange function = new FunctionRange();
        List<Double> result = function.diapason(4, 7, x -> x * x + 1);
        List<Double> expected = Arrays.asList(17D, 26D, 37D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionRange function = new FunctionRange();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(4, x) + 1);
        List<Double> expected = Arrays.asList(5D, 17D, 65D);
        assertThat(result, is(expected));
    }
}