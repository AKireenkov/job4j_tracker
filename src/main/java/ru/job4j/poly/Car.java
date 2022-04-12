package ru.job4j.poly;

public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " driving on the highway");
    }
}
