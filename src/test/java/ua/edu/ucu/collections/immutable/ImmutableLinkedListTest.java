package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test(expected = InputMismatchException.class)
    public void testAddIndex() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.add(0, 33333);
        assertEquals(new ImmutableLinkedList(new Node(33333)), list);
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.add(303);
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddAllIndex() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.addAll(0, new Object[]{1, 2, 3, 4});
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3, 4});
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testRemove() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.remove(4);
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testSet() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.set(0, 34);
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testGet() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = (ImmutableList)linkedList.get(0);
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        int index = linkedList.indexOf(1);
        Object expected = -1;
        Object actual = index;
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList list = linkedList.clear();
        Object expected = "";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        Object[] array = linkedList.addAll(new Object[]{1, 2, 3, 4}).toArray();
        Object expected = "[]";
        Object actual = Arrays.toString(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        boolean statement = linkedList.isEmpty();
        Object expected = true;
        Object actual = statement;
        assertEquals(expected, actual);
    }

}
