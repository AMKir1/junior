package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Chapter_003. Collection. Lite.
 * Task: Банковские переводы. [#10038]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    /**
     * User Addition Test.
     */
    @Test
    public void testAddUser() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        bank.addUser(user);
        assertThat(bank.findUser(user.getPassport()), is(user));
    }
    /**
     * Test for adding an account to a user.
     */
    @Test
    public void testAddAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        List<AccountOfUser> accs  = new ArrayList<>();
        accs.add(acc);
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        assertThat(bank.getUserAccounts(user.getPassport()), is(accs));
    }
    /**
     * User deletion test.
     */
    @Test
    public void testDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        bank.deleteUser(user);
        User result = null;
        assertThat(bank.findUser(user.getPassport()), is(result));
    }
    /**
     * User account deletion test.
     */
    @Test
    public void testDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        AccountOfUser acc2 = new AccountOfUser(0, "0000 0000 0000 0001");
        List<AccountOfUser> accs  = new ArrayList<>();
        accs.add(acc);
        accs.add(acc2);
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        bank.addAccountToUser(user.getPassport(), acc2);
        bank.deleteAccountFromUser(user.getPassport(), acc);
        accs.remove(acc);
        assertThat(bank.getUserAccounts(user.getPassport()), is(accs));
    }
    /**
     * Test of obtaining the list of user accounts.
     */
    @Test
    public void testGetUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        AccountOfUser acc2 = new AccountOfUser(0, "0000 0000 0000 0001");
        List<AccountOfUser> accs  = new ArrayList<>();
        accs.add(acc);
        accs.add(acc2);
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        bank.addAccountToUser(user.getPassport(), acc2);
        assertThat(bank.getUserAccounts(user.getPassport()), is(accs));
    }
    /**
     * Transaction failure test when there are not enough funds on the account.
     */
    @Test
    public void testImpossible1TransferMoney() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        AccountOfUser acc2 = new AccountOfUser(0, "0000 0000 0000 0001");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        bank.addAccountToUser(user.getPassport(), acc2);
        assertThat(bank.transferMoney(user.getPassport(), acc.getRequisites(), user.getPassport(), acc2.getRequisites(), 100), is(false));
    }
    /**
     * Test failure of the transaction, when there is no account from which you need to send money.
     */
    @Test
    public void testImpossible2TransferMoney() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0001");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        assertThat(bank.transferMoney(user.getPassport(), "0000 0000 0000 0000", user.getPassport(), acc.getRequisites(), 100), is(false));
    }
    /**
     * Test failure of the transaction, when there is no account to which you need to send money.
     */
    @Test
    public void testImpossible3TransferMoney() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(1000, "0000 0000 0000 0000");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        assertThat(bank.transferMoney(user.getPassport(), acc.getRequisites(), user.getPassport(), "0000 0000 0000 0001", 100), is(false));
    }
    /**
     * Successful transaction test.
     */
    @Test
    public void testTransferMoney() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        AccountOfUser acc = new AccountOfUser(101, "0000 0000 0000 0000");
        AccountOfUser acc2 = new AccountOfUser(0, "0000 0000 0000 0001");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), acc);
        bank.addAccountToUser(user.getPassport(), acc2);
        assertThat(bank.transferMoney(user.getPassport(), acc.getRequisites(), user.getPassport(), acc2.getRequisites(), 100), is(true));
    }
    /**
     * User search test when not found.
     */
    @Test
    public void testNotFindUser() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        bank.addUser(user);
        User result = null;
        assertThat(bank.findUser("0000 000001"), is(result));
    }
    /**
     * User search test.
     */
    @Test
    public void testFindUser() {
        Bank bank = new Bank();
        User user = new User("Petr", "0000 000000");
        bank.addUser(user);
        assertThat(bank.findUser("0000 000000"), is(user));
    }
}
