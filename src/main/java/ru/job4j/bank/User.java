package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс содержит описание модели пользователя
 * @author ANDREY KIREENKOV
 * @version 1.0
 */
public class User {
    /**
     * Модель данных "Пользователь" содержит поля "паспорт пользователя" и "имя пользователя"
     */
    private String passport;
    private String username;

    /**
     * Конструктор, который определяет, минимальное количество атрибутов,
     * необходимых для создания объекта типа Пользователь
     * @param passport номер паспорта нового пользователя
     * @param username ФИО нового пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер паспорта пользователя
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет заменить номер паспорта пользователя
     * @param passport номер паспорта, на который необходимо заменить текущее значения паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО пользователя
     * @return ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет заменить ФИО пользователя
     * @param username ФИО пользователя, на которые необходимо заменить текущее ФИО пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}