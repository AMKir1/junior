package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Chapter_003. Collection. Lite.
 * Task: Конвертация двумерного массива в ArrayList и наоборот [#10035]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class AccountTest {

    @Test
    /*
     * Testing converter to Array from List.
     */
    public void testAddUser() {
        Map<User, List<Account>> map = new HashMap<>();
        User user = new User("Petr", "3525 456123");
        Account account = new Account(0, "0000000000");
        account.addUser(user);
        List<Account> accounts = account.getUserAccounts(user.getPassport());
        List<Account> result = new ArrayList<>();
        result.add(account);
        assertThat(accounts.get(0), is(result));
    }

    @Test
    /*
     * Testing converter to Array from List.
     */
    public void testDeleteUser() {


        //assertThat(list, is(result));
    }

    @Test
    /*
     * Testing converter to Array from List.
     */
    public void testAddAccount() {
        //assertThat(list, is(result));
    }

    @Test
    /*
     * Testing converter to Array from List.
     */
    public void testDeleteAccount() {


       // assertThat(list, is(result));
    }

    @Test
    /*
     * Testing converter to Array from List.
     */
    public void testTransfer() {


        //assertThat(list, is(result));
    }


}
