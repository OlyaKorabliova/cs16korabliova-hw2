package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList list = new ImmutableLinkedList();

    public Object peek() {
        return list.start.nextNode.data;
    }
    public Object dequeue() {
        Object o = peek();
        list.remove(0);
        return o;
    }

    public void enqueue(Object e) {
        list.add(0, e);
    }

    public String toString() {
        return list.toString();
    }

}
