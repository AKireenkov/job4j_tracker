package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int num) {
        return sum(num) + multiply(num) + minus(num) + divide(num);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(minus(6));
        System.out.println(calculator.divide(10));
        System.out.println(sum(10));
        System.out.println(calculator.multiply(5));
        System.out.println(calculator.sumAllOperation(10));
    }
}
