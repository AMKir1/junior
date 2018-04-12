package ru.job4j.bank;

import java.util.*;
/**
 * Chapter_003. Collection. Lite.
 * Task: Банковские переводы. [#10038]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class Bank {
    /**
     * Карта пользователей с их счетами
     */
    Map<User, List<AccountOfUser>> accounts = new HashMap<>();
    /**
     * Добавление пользователя.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        this.accounts.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * Добавление счета пользователю.
     *
     * @param passport паспорт пользователя.
     * @param account новый счет.
     */
    public void addAccountToUser(String passport, AccountOfUser account) {
       if (!this.accounts.get(findUser(passport)).contains(account)) {
           this.accounts.get(findUser(passport)).add(account);
       }
    }
    /**
     * Удаление пользователя.
     *
     * @param user пользователь.
     */
    public void deleteUser(User user) {
        this.accounts.remove(user);
    }
    /**
     * Удаление счета пользователя.
     *
     * @param passport  паспорт пользователя.
     * @param account  счет, кторый нужно удалить.
     */
    public void deleteAccountFromUser(String passport, AccountOfUser account) {
        this.accounts.get(findUser(passport)).remove(account);
    }
    /**
     * Получение списка счетов пользователя.
     *
     * @param passport  паспорт пользователя, счета которого нужно вывести.
     * @return список счетов.
     */
    public List<AccountOfUser> getUserAccounts(String passport) {
        return this.accounts.get(findUser(passport));
    }
    /**
     * Перечисление денег.
     *
     * @param srcPassport  паспорт отправителя.
     * @param srcRequisite номер счета отправителя.
     * @param destPassport паспорт получателя.
     * @param dstRequisite номер счета получателя.
     * @param amount       сумма.
     * @return результат перечисления.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean status = false;
        User userFrom = findUser(srcPassport);
        User userTo = findUser(destPassport);
        AccountOfUser accTo = null;
        AccountOfUser accFrom = null;
        if (userFrom != null && userTo != null) {
            for (AccountOfUser acc : this.accounts.get(userFrom)) {
                if (acc.getRequisites().equals(srcRequisite) && acc.getValue() >= amount) {
                    accFrom = acc;
                    break;
                }
            }
            for (AccountOfUser acc : this.accounts.get(userTo)) {
                if (acc.getRequisites().equals(dstRequisite)) {
                    accTo = acc;
                    break;
                }
            }
            if (accFrom != null && accTo != null) {
                status = true;
                accFrom.setValue(accFrom.getValue() - amount);
                accTo.setValue(accTo.getValue() + amount);
            }
        }
        return status;
    }
    /**
     * Поиск пользователя по паспорту.
     *
     * @param passport  паспорт пользователя, которого нужно найти.
     * @return пользователь.
     */
    public User findUser(String passport) {
        User user = null;
        for (User key : this.accounts.keySet()) {
            if (key.getPassport().equals(passport)) {
                user = key;
                break;
            }
        }
        return user;
    }
}
