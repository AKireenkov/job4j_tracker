package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String branch;

    public Surgeon(String name, String surname, String education, int birthday, int salary, String branch) {
        super(name, surname, education, birthday, salary);
        this.branch = branch;
    }

    public String branchName() {
        return null;
    }

    ;
}
