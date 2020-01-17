package ru.job4j.generic;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.2. Реализовать Store<T extends Base> [#157]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {

    Store<User> userStore;
    Store<Role> roleStore;

    @Before
    public void init() {
        userStore = new UserStore();
        roleStore = new RoleStore();
        userStore.add(new User("Andrew"));
        userStore.add(new User("Alex"));
        userStore.add(new User("Anton"));

        roleStore.add(new Role("junior"));
        roleStore.add(new Role("middle"));
        roleStore.add(new Role("senior"));
    }

    @Test
    public void whenRemoveTest() {
        assertThat(userStore.toString(), is("{ User - Andrew User - Alex User - Anton }"));
        assertThat(roleStore.toString(), is("{ Role - junior Role - middle Role - senior }"));
        assertThat(userStore.delete("Andrew"), is(true));
        assertThat(roleStore.delete("junior"), is(true));
        assertThat(userStore.toString(), is("{ User - Alex User - Anton }"));
        assertThat(roleStore.toString(), is("{ Role - middle Role - senior }"));
    }

    @Test
    public void whenReplaceTest() {
        assertThat(userStore.toString(), is("{ User - Andrew User - Alex User - Anton }"));
        assertThat(roleStore.toString(), is("{ Role - junior Role - middle Role - senior }"));
        userStore.replace("Andrew", new User("EMPTY"));
        roleStore.replace("junior", new Role("EMPTY"));
        assertThat(userStore.toString(), is("{ User - EMPTY User - Alex User - Anton }"));
        assertThat(roleStore.toString(), is("{ Role - EMPTY Role - middle Role - senior }"));
    }

    @Test
    public void whenFindByIdTest() {
        assertThat(userStore.toString(), is("{ User - Andrew User - Alex User - Anton }"));
        assertThat(roleStore.toString(), is("{ Role - junior Role - middle Role - senior }"));
        assertThat(userStore.findById("Andrew").toString(), is("User - Andrew"));
        assertThat(roleStore.findById("junior").toString(), is("Role - junior"));
    }
}
