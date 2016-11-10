package ua.edu.ucu.collections.immutable;


import java.util.InputMismatchException;

public class ImmutableLinkedList implements ImmutableList {

    public int listSize = 0;
    public Node start;

    public ImmutableLinkedList() {
        start = new Node(null);
    }

    public ImmutableLinkedList(Node node) {
        start = node;
        Node curNode = start.getNextNode();
        if (curNode != null) {
            listSize++;
        }
        while (curNode != null) {
            listSize++;
            curNode = curNode.nextNode;
        }
    }

    @Override
    public ImmutableList add(Object e) {
        Node newNode = start.clone();
        if (listSize != 0) {
            Node element = new Node(e);
            Node curNode = start;
            while (curNode.getNextNode() != null) {
                Node n = curNode.getNextNode().clone();
                newNode.setNextNode(n);
                newNode = n;
                curNode = curNode.getNextNode();
            }
            newNode.setNextNode(element);
        }
        else {
            start = new Node(e);
            start.setNextNode(null);
            listSize++;
            return new ImmutableLinkedList(start);
        }
        listSize++;
        return new ImmutableLinkedList(newNode);
    }

    public void addAtFirstPos(Object e) {
        if (isEmpty()) {
            add(e);
        }
        add(0, e);
    }

    public void addAtLastPos(Object e) {
        if (isEmpty()) {
            add(e);
        }
        add(listSize, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index < 0 || index > listSize || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        Node newNode = start.clone();
        Node curNode = start;
        Node element = new Node(e);
        for (int i = 0; i < index && curNode.getNextNode() != null; i++) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        newNode.setNextNode(element);
        newNode = newNode.getNextNode();
        while (curNode.getNextNode() != null) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        listSize++;
        return new ImmutableLinkedList(newNode);
    }
    
    @Override
    public ImmutableList addAll(Object[] c) {
        Node curNode = start;
        Node newNode = start.clone();
        for (int j = 0; j < listSize && curNode.getNextNode() != null; j++) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        for (int i = 0; i < c.length; i++) {
            listSize++;
            newNode.setNextNode(new Node(c[i]));
            newNode = newNode.getNextNode();
        }
        return new ImmutableLinkedList(newNode);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > listSize || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        Node curNode = start;
        Node newNode = start.clone();
        for (int j = 0; j < index && curNode.getNextNode() != null; j++) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        for (int i = 0; i < c.length; i++) {
            listSize++;
            newNode.setNextNode(new Node(c[i]));
            newNode = newNode.getNextNode();
        }
        while (curNode.getNextNode() != null) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        return new ImmutableLinkedList(newNode);
    }

    @Override
    public Object get(int index) {
        Node newNode = start.clone();
        if (index < 0 || index > listSize || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        Node curNode = start;
        for (int i = 0; i < index && curNode.getNextNode() != null; i++) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        return newNode.getData();
    }

    @Override
    public ImmutableList remove(int index) {
        Node curNode = start;
        Node newNode = start.clone();
        if (index < 0 || index > listSize || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        for (int i = 0; i < listSize && curNode.getNextNode() != null; i++) {
            if (i > 1 && i < index - 1) {
                Node n = curNode.getNextNode().clone();
                newNode.setNextNode(n);
                newNode = n;
                curNode = curNode.getNextNode();
            }
            else if (i == index - 1) {
                newNode.setNextNode(curNode.getNextNode().getNextNode());
                newNode = newNode.getNextNode();
                curNode = curNode.getNextNode();
            }
            else if (i >= index) {
                Node n = curNode.getNextNode().clone();
                newNode.setNextNode(n);
                newNode = n;
                curNode = curNode.getNextNode();
            }
        }
        listSize--;
        return new ImmutableLinkedList(newNode);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > listSize || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        Node newNode = start.clone();
        Node curNode = start;
        Node element = new Node(e);
        for (int i = 0; i < index - 1 && curNode.getNextNode() != null; i++) {
            Node n = curNode.getNextNode().clone();
            newNode.setNextNode(n);
            newNode = n;
            curNode = curNode.getNextNode();
        }
        newNode.setNextNode(element);
        return new ImmutableLinkedList(newNode);
    }

    @Override
    public int indexOf(Object e) {
        if (!isEmpty()) {
            Node curNode = start;
            int j = 0;
            while (j < listSize && curNode != e && curNode != null) {
                curNode = curNode.getNextNode();
                j++;
            }
            if (curNode == null) {
                return -1;
            }
            return j;
        }
        return -1;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public ImmutableList clear() {
        int i = listSize;
        while (i > 0) {
            remove(0);
            i--;
        }
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (listSize == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        Node curNode = start.getNextNode();
        String k = "";
        while (curNode != null) {
            k += "[" + curNode.getData().toString() + "]";
            curNode = curNode.getNextNode();
        }
        return k;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[listSize];
        Node curNode = start;
        for (int i = 0; i < listSize; i++) {
            array[i] = curNode;
            curNode = curNode.getNextNode();
        }
        return array;
    }

    public static void main(String args[]) {
        ImmutableLinkedList list = new ImmutableLinkedList();
        System.out.println("++++++++++");
        list.addAll(new Object[] {-1, -2, -3});
        System.out.println(list);

        list.add(3);
        /*System.out.println(list);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("========== 3");

        list.add(0, 400);
        System.out.println(list);
        list.add(3, 300);
        System.out.println(list);
        list.add(2, 200);
        System.out.println(list.size());
        System.out.println("========== 6");

        System.out.println(list);
        list.add(50);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("========== 7");
        list.addAll(new Object[] {-1, -2, -3});
        System.out.println(list);
        list.addAll(2, new Object[] {-1, -2, -3});

        System.out.println("------------");
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(1));
        list.set(3, "efe");
//        System.out.println(list);
//        list.toArray();
        list.clear();
        System.out.println(list.size());
//        list.addAll(3, new Object[]{-1, -2, -3, -4});
//        System.out.println(list);
*/
    }
}
