package ru.job4j.inheritance;

public class Builder extends Engineer {
    private boolean driverLicense;

    public Builder(String name, String surname, String education, int birthday, String gender, boolean driverLicense) {
        super(name, surname, education, birthday, gender);
        this.driverLicense = driverLicense;
    }

    public boolean isDriverLicense(boolean driverLicense) {
        return false;
    }
}
