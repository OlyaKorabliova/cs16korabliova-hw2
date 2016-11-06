package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        return queue.get(0);
    }

    public Object dequeue() {
        Object removed = queue.get(0);
        queue.remove(0);
        return removed;
    }

    public void enqueue(Object e) {
        queue.add(0, e);
    }


}
