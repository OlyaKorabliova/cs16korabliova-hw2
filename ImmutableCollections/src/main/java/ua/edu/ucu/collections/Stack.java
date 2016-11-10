package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList list = new ImmutableLinkedList();

    public Object peek() {
        return list.end.data;
    }

    public Object pop() {
        Object o = peek();
        list.remove(list.listSize);
        return o;
    }

    public void pop(Object e) {
        list.add(e);
    }

    public String toString() {
        return list.toString();
    }
}
