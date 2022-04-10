package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String job;

    public Dentist(String name, String surname, String education, int birthday, int salary, String job) {
        super(name, surname, education, birthday, salary);
        this.job = job;
    }

    public String job(String job) {
        return null;
    }
}
