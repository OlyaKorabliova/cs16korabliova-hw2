package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;

public class Stack {

    ImmutableArrayList stack = new ImmutableArrayList();

    public Object peek() {
        return stack.array[stack.array.length - 1];
    }

    public Object pop() {
        Object removed = peek();
        stack.remove(stack.array.length - 1);
        return removed;
    }

    public void pop(Object e) {
        stack.add(stack.array.length - 1, e);
    }

    public String toString() {
        return stack.toString();
    }

}
