package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");

        for (String car : autos) {
            System.out.println(car);
        }
    }
}

/*
 Добавьте в коллекцию autos марки машин: Lada, BMW, Volvo, Toyota.
3. Добавьте цикл for-each и выведите элементы коллекции HashSet на консоль.
 */