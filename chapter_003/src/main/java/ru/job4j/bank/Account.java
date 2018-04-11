package ru.job4j.bank;

import java.util.*;

public class Account {

   private double value; //кол-во денег
   private String requisites; //банковский счёт

    Map<User, List<Account>> accounts = new HashMap<>();

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addUser(User user) {
      List<Account> acc = new ArrayList<>();
      acc.add(new Account(0, randomNumberAccaunt()));
      this.accounts.putIfAbsent(user, acc);
    }

    public void addAccountToUser(String passport, Account account) {
        List<User> users = new ArrayList<>(this.accounts.hashCode());
        List<Account> acc = new ArrayList<>();
        acc.add(new Account(0, randomNumberAccaunt()));
        for (User user : users) {
            if (user.getPassport().equals(passport)) {
                this.accounts.putIfAbsent(user, acc);
            }
        }
    }

    public void deleteUser(User user) {
        Map<User, List<Account>> map = new HashMap<User, List<Account>>(accounts);
        Iterator<List<Account>> it = map.values().iterator();
        while(it.hasNext()) {
            if(map.containsKey(user)) {
                map.remove(user);
                break;
            }
        }
    }

    public String randomNumberAccaunt() {
        return (long) (Math.random() * ((long) Math.pow(10, 10 - 1) * 9)) + (long) Math.pow(10, 10 - 1) * 1 +"";
    }

    public void deleteAccountfromUser(String passport, Account account) {
        List<User> users = new ArrayList<>(this.accounts.hashCode());
        for (User user : users) {
            if (user.getPassport().equals(passport)) {
                this.accounts.remove(user, account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts (String passport) {
        List<User> users = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++) {
            users.add(accounts.get());
        }

        List<Account> accs = new ArrayList<>();
        for (User user : users) {
            if (user.getPassport().equals(passport)) {
                accs = this.accounts.get(user);
                break;
            }
        }
        return accs;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean status = false;
        User user1 = new User("","");
        User user2 = new User("", "");
        List<User> users = new ArrayList<>(this.accounts.hashCode());
        List<Account> accs = new ArrayList<>();
        List<Account> accs2 = new ArrayList<>();
        for (User user : users) {
            if (user.getPassport().equals(srcPassport)) {
                user1.setName(user.getName());
                user1.setPassport(user.getPassport());
            }

            if (user.getPassport().equals(destPassport)) {
                user2.setName(user.getName());
                user2.setPassport(user.getPassport());
            }
        }
        Map<User, List<Account>> map = new HashMap<User, List<Account>>(accounts);
        Iterator<List<Account>> it = map.values().iterator();
        while(it.hasNext()) {
            if(map.containsKey(user1)) {
                accs = map.get(user1);
            }
            if(map.containsKey(user2)) {
                accs2 = map.get(user2);
            }
        }
        for(Account acc : accs) {
            if (acc.getRequisites() == srcRequisite) {
                if (acc.getValue() > amount) {
                    status = true;
                    acc.setValue(acc.getValue() - amount);
                    break;
                }
            } else {
                status = false;
            }
        }
        for(Account acc2 : accs2) {
            if(acc2.getRequisites() == dstRequisite) {
                status = true;
                acc2.setValue(acc2.getValue() + amount);
            } else {
                status = false;
            }
        }
        return status;
    }



}
