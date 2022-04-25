package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addWithDuplicate() {
        Citizen one = new Citizen("2f44a", "Petr Arsentev");
        Citizen two = new Citizen("2f44a", "Andrey Kireenkov");
        PassportOffice office = new PassportOffice();
        office.add(one);
        Assert.assertFalse(office.add(two));
    }
}