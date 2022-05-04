package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит описание банковского сервиса, где описана работа со счетами пользователей
 * @author ANDREY KIREENKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа Map
     * Ключ - сам пользователь
     * Значение - список счетов пользователя
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить пользователя в коллекцию
     * По умолчанию, для пользователя создается пустой список счетов
     * @param user пользователь, которого добавляем в коллекцию users
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяет добавить счет пользователю
     * Предварительно, производится поиск пользователя по паспорту
     * Новый счет будет добавлен, если пользователь найден, и добавляемого счета у него нет
     * @param passport номер паспорта, по которому производится поиск пользователя
     * @param account номер счета, который необходимо добавить пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод позволяет производить поиск пользователя по паспорту в системе
     * @param passport номер паспорта, по которому производится поиск
     * @return возвращает пользователя, если такой найден, в противном случае возвращает null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет найти счет по номеру счета
     * Предварительно, производится поиск пользователя по паспорту
     * Если пользователь найден, получаем список его счетов
     * Затем происходит сравнение реквизитов каждого счета из полученного списка, с реквизитами по которым ищем
     * @param passport номер паспорта, по которому производится поик пользователя
     * @param requisite реквизиты счета, по которым происходит поиск счета
     * @return возвращает найденный счет с реквизитами и балансом, в противном случае возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет перевести деньги с одного счета на другой
     * Предварительно, производится поиск счетов списния и получения
     * Если, оба счета найдены, и на счете для списания есть достаточная сумма для списания
     * Со счета списания - вычесть, на счет получения - добавить нужную сумму
     * @param srcPassport номер паспорта пользователя со счета которого производится списание
     * @param srcRequisite реквизиты счета с которого производится списание
     * @param destPassport номер паспорта пользователя на счет которого поступают денежные средства
     * @param destRequisite реквизиты счета который пополняем
     * @param amount сумма перевода
     * @return возвращаем true если перевод удалось совершить, в противном случае возвращается false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}