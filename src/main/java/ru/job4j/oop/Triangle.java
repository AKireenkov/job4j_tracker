package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac) < bc || (ab + bc) < ac || (bc + ac) < ab;
    }

    public double area() {
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double rsl = Math.sqrt(semiPerimeter(ab, ac, bc) * (semiPerimeter(ab, ac, bc) - ab) * (semiPerimeter(ab, ac, bc) - ac) * (semiPerimeter(ab, ac, bc) - bc));
        if (this.exist(ab, ac, bc)) {
            rsl = -1;
        }
        return rsl;
    }
}
