package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String gender;

    public Engineer(String name, String surname, String education, int birthday, String gender) {
        super(name, surname, education, birthday);
        this.gender = gender;
    }

    public String gender(String gender) {
        return null;
    }
}
