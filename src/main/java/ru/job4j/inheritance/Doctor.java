package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int salary;

    public Doctor(String name, String surname, String education, int birthday, int salary) {
        super(name, surname, education, birthday);
        this.salary = salary;
    }

    public int salary(int salary) {
        return salary;
    }
}
