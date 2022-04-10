package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String education, int birthday, String gender, String lang) {
        super(name, surname, education, birthday, gender);
        this.lang = lang;
    }

    public void programmingLang() {
    }
}
