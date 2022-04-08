package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void when12nd42and12ThenMinus1() {
        Point a = new Point(1, 2);
        Point b = new Point(4, 2);
        Point c = new Point(1, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }

    @Test
    public void when01to00to00then1() {
        int expected = 1;
        Point c = new Point(0, 1, 0);
        Point d = new Point(0, 0, 0);
        double dist = c.distance3d(d);
        Assert.assertEquals(expected, dist, 0.01);
    }
}