package ru.job4j.depart;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class DepartsTest {

    @Test
    public void testRecoveryandSortUp() {
        String[] arr = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2"};
        Departs departs = new Departs();
        String[] result = departs.sortUp(arr);
        String[] excepted = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2"};
        Assert.assertThat(result, is(excepted));
    }

    @Test
    public void testRecoveryandSortDown() {
        String[] arr = {
                "K2\\SK1\\SSK2",
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1"};
        Departs departs = new Departs();
        String[] result = departs.sortDown(arr);
        String[] excepted = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        Assert.assertThat(result, is(excepted));
    }

}
