package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAdd() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        ImmutableList list = arrayList.add(3);
        Object expected = "[3]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddIndex() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        Object[] arr = new Object[]{0, 1, 2, 3, 4};
        arrayList.addAll(arr);
        ImmutableList list = arrayList.add(2, 44);
        Object expected = "[0, 1, 44, 3, 4]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        Object[] arr = new Object[]{0, 1, 2, 3, 4};
        ImmutableList list = arrayList.addAll(arr);
        Object expected = "[null, 0, 1, 2, 3, 4]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAllIndex() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        Object[] arr = new Object[]{0, 1, 2, 3, 4};
        arrayList.add(10000);
        ImmutableList list = arrayList.addAll(0, arr);
        Object expected = "[null]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testRemove() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        ImmutableList list = arrayList.addAll(new Object[]{0, 1, 2, 3, 4}).remove(2);
        Object expected = "[null, 0, 2, 3, 4]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testSet() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        ImmutableList list = arrayList.addAll(new Object[]{0, 1, 2, 3, 4}).set(2, "aba");
        Object expected = "[null, 0, aba, 2, 3, 4]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InputMismatchException.class)
    public void testGet() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        Object obj = arrayList.addAll(new Object[]{0, 1, 2, 3, 4}).get(2);
        Object expected = "1";
        Object actual = obj.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        int index = arrayList.addAll(new Object[]{0, 1, 2, 3, 4}).indexOf(2);
        Object expected = 3;
        Object actual = index;
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        ImmutableList list = arrayList.addAll(new Object[]{0, 1, 2, 3, 4}).clear();
        Object expected = "[null]";
        Object actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        boolean bool = arrayList.addAll(new Object[]{0, 1, 2, 3, 4}).isEmpty();
        Object expected = true;
        Object actual = bool;
        assertEquals(expected, actual);
    }
}
