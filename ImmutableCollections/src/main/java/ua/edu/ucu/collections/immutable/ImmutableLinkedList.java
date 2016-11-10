package ua.edu.ucu.collections.immutable;

import java.util.InputMismatchException;

public class ImmutableLinkedList implements ImmutableList {

    public int listSize = 0;
    public Node start;
    public Node end;

    public ImmutableLinkedList() {
        this.start = this.end = new Node(null);
    }

    public ImmutableLinkedList(Node node) {
        this.start = node;
        Node curNode = this.start.nextNode;

        if (curNode != null) {
            this.listSize++;
        }
        while (curNode != null) {
            curNode = curNode.nextNode;
            this.listSize++;
        }
    }


    @Override
    public ImmutableList add(Object e) {
        add(this.listSize, e);
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Node tempNode = new Node(e);
        Node curNode = this.start;
        if (!isEmpty() && index == 0) {
            tempNode.nextNode = this.start;
            this.start = tempNode;
        }
        else if (!isEmpty() && 0 < index && index < this.listSize) {
            for (int i = 1; i < index; i++) {
                curNode = curNode.nextNode;
            }
        }
        else {
            throw new InputMismatchException("Index out of range!");
        }
        this.listSize++;
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        for (int i = 0; i < c.length; i++) {
            this.add(c[i]);
        }
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (!isEmpty() && index == 0) {

            Node elementWithPrevInd = this.start;
            Node elementWithLastInd = this.start.nextNode;

            for (int i = 0; i < c.length; i++) {
                Node newNode = new Node(c[i]);
                elementWithPrevInd.nextNode = newNode;
                elementWithPrevInd = newNode;
                this.listSize++;
            }
            elementWithPrevInd.nextNode = elementWithLastInd;
            return new ImmutableLinkedList(this.start);

        }
        else if (!isEmpty() && 0 < index && index < this.listSize) {
            Node elementWithPrevInd = this.start.nextNode;
            for (int i = 1; i < c.length; i++) {
                elementWithPrevInd = elementWithPrevInd.nextNode;
            }
            Node elementWithLastInd = elementWithPrevInd.nextNode;
            for (int i = 0; i < c.length; i++) {
                Node newNode = new Node(c[i]);
                elementWithPrevInd.nextNode = newNode;
                elementWithPrevInd = newNode;
                this.listSize++;
            }
            elementWithPrevInd.nextNode = elementWithLastInd;
        }
        else {
            throw new InputMismatchException("Index out of range!");
        }
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public Object get(int index) {
        Node curNode = this.start;
        for (int i = 0; i < index; i++) {
            curNode = curNode.nextNode;
        }
        return curNode.data;
    }

    @Override
    public ImmutableList remove(int index) {
        Node curNode = this.start;
        if (index == 0) {
            this.start = this.start.nextNode;
        }
        else if (!isEmpty() && 0 < index && index < this.listSize) {
            for (int i = 1; i < index; i++) {
                curNode = curNode.nextNode;
            }
            curNode.nextNode = curNode.nextNode.nextNode;
        }
        else {
            throw new InputMismatchException("Index out of range!");
        }
        this.listSize--;
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index == 0) {
            this.start.nextNode.data = e;
        }
        else if (!isEmpty() && index > 0 && index < this.listSize) {
            Node curNode = this.start.nextNode;
            for (int i = 1; i <= index; i++) {
                curNode = curNode.nextNode;
            }
            curNode.data = e;
        }

        else {
            throw new InputMismatchException("Index out of range!");
        }
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public int indexOf(Object e) {
        if (!isEmpty()) {
            Node curNode = this.start.nextNode;
            int j = 0;
            while (curNode != null && curNode.data != e) {
                j++;
                curNode = curNode.nextNode;
            }
            if (this.start.nextNode.data == e || j != 0) {
                return j;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    @Override
    public int size() {
        return this.listSize;
    }

    @Override
    public ImmutableList clear() {
        this.start = this.end = new Node(null);
        this.listSize = 0;
        return new ImmutableLinkedList(this.start);
    }

    @Override
    public boolean isEmpty() {
        if (this.listSize != 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.listSize];
        Node curNode = this.start.nextNode;
        for (int i = 0; i < this.listSize; i++) {
            array[i] = curNode.data;
            curNode = curNode.nextNode;
        }
        return array;
    }
}
