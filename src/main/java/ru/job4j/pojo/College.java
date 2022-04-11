package ru.job4j.pojo;

import java.util.Calendar;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Kireenkov Andrey Alekseevich");
        student.setGroup(12);
        student.setDateOfEntry(new Date(2013, Calendar.SEPTEMBER, 1));
        System.out.println(student.getName() + " studying in a group " + student.getGroup() + " , date of entry: " + student.getDateOfEntry());
    }
}
