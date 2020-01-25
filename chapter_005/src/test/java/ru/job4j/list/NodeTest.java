package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.4. Задан связанный список. Определить цикличность. [#161]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NodeTest {
    Node node1 = new Node<>(1);
    Node node2 = new Node<>(2);
    Node node3 = new Node<>(3);
    Node node4 = new Node<>(4);

    @Test
    public void whenNodeIsNextByOtherNode() {
        node1.next = node2;
        assertThat(node1.toString(), is("Node: { value: 1, next: 2 }"));
    }

    @Test
    public void whenNode1hasCycleWithNode1() {
        node1.next = node1;
        assertThat(node1.toString(), is("Node: { value: 1, next: 1 }"));
        assertThat(Node.hasCycle(node1), is(true));
    }

    @Test
    public void whenNode1hasCycleWithNextNode() {
        node1.next = node2;
        node2.next = node1;
        assertThat(node1.toString(), is("Node: { value: 1, next: 2 }"));
        assertThat(node2.toString(), is("Node: { value: 2, next: 1 }"));
        assertThat(Node.hasCycle(node1), is(true));
        assertThat(Node.hasCycle(node2), is(true));
    }

    @Test
    public void whenNode1hasCycleWithNNode() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        assertThat(node1.toString(), is("Node: { value: 1, next: 2 }"));
        assertThat(node2.toString(), is("Node: { value: 2, next: 3 }"));
        assertThat(node3.toString(), is("Node: { value: 3, next: 4 }"));
        assertThat(node4.toString(), is("Node: { value: 4, next: 1 }"));
        assertThat(Node.hasCycle(node1), is(true));
        assertThat(Node.hasCycle(node2), is(true));
        assertThat(Node.hasCycle(node3), is(true));
        assertThat(Node.hasCycle(node4), is(true));
    }

    @Test
    public void whenNode3hasCycleWithNode3() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node3;
        assertThat(node1.toString(), is("Node: { value: 1, next: 2 }"));
        assertThat(node2.toString(), is("Node: { value: 2, next: 3 }"));
        assertThat(node3.toString(), is("Node: { value: 3, next: 3 }"));
        assertThat(Node.hasCycle(node1), is(true));
        assertThat(Node.hasCycle(node2), is(true));
        assertThat(Node.hasCycle(node3), is(true));
    }

    @Test
    public void whenNode2hasCycleWithNode3() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        node4.next = node2;
        assertThat(node1.toString(), is("Node: { value: 1, next: 2 }"));
        assertThat(node2.toString(), is("Node: { value: 2, next: 3 }"));
        assertThat(node3.toString(), is("Node: { value: 3, next: 2 }"));
        assertThat(node4.toString(), is("Node: { value: 4, next: 2 }"));
        assertThat(Node.hasCycle(node1), is(true));
        assertThat(Node.hasCycle(node2), is(true));
        assertThat(Node.hasCycle(node3), is(true));
        assertThat(Node.hasCycle(node4), is(true));
    }

    @Test
    public void whenNodeHasNotCycle() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        assertThat(node1.toString(), is("Node: { value: 1, next: 2 }"));
        assertThat(node2.toString(), is("Node: { value: 2, next: 3 }"));
        assertThat(node3.toString(), is("Node: { value: 3, next: 4 }"));
        assertThat(node4.toString(), is("Node: { value: 4, next: null }"));
        assertThat(Node.hasCycle(node1), is(false));
        assertThat(Node.hasCycle(node2), is(false));
        assertThat(Node.hasCycle(node3), is(false));
        assertThat(Node.hasCycle(node4), is(false));
    }
}
