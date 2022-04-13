package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус двигается по заранее намечнному маршруту");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Количество пассажиров в автобусе: " + amount);
    }

    @Override
    public int refuel(int amount) {
        int costPerLiter = 10;
        return amount * costPerLiter;
    }
}
