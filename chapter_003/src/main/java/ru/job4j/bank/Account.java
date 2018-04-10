package ru.job4j.bank;

import java.util.*;

public class Account {

   private int value; //кол-во денег
   private String requisites; //банковский счёт

    Map<User, List<Account>> accounts = new HashMap<>();

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addUser(User user) {
      Map<User, List<Account>> map = new HashMap<User, List<Account>>(accounts);
      Iterator<List<Account>> it = map.values().iterator();
      while(it.hasNext()) {
         if(!map.containsKey(user)) {
             map.put(user, new List<Account>();
         } else {

         }
      }
    }


}
