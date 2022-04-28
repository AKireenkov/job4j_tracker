package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс содержит описание модели банковского счета
 * @author ANDREY KIREENKOV
 * @version 1.0
 */
public class Account {
    /**
     * Модель данных "Счет" содержит поля "реквизиты" и "баланс"
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор, который определяет, минимальное количество атрибутов,
     * необходимых для создания объекта типа Счет
     * @param requisite реквизиты нового счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет заменить реквизиты счета
     * @param requisite реквизиты, на которые необходимо заменить текущие реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет заменить баланс счета
     * @param balance баланс, на который необходимо заменить текущий баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}