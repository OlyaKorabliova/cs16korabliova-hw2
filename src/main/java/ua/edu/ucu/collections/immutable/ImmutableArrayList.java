package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public class ImmutableArrayList implements ImmutableList {

    public Object[] array;
    public int size = 0;

    public ImmutableArrayList() {
        array = new Object[1];
    }

    public ImmutableArrayList(Object[] items) {
        array = items;
    }

    @Override
    public ImmutableList add(Object e) {
        if (isEmpty()) {
            array[0] = e;
            size++;
//            System.out.println(Arrays.toString(array));
            return new ImmutableArrayList(array);
        }
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.size = size;
        arr.array = Arrays.copyOf(array, arr.size);
        arr.size++;
        arr.array[size - 1] = e;
//        System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList(arr.array);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.array = new Object[array.length + 1];
        arr.size = size;
        if (index < 0 || index > arr.size || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                arr.array[i] = array[i];
            }
            else if (i > index) {
                arr.array[i] = array[i - 1];
            }
            else {
                arr.array[i] = e;
            }
        }
        arr.size++;
//        System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList(arr.array);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.array = new Object[array.length + c.length];
        arr.size = size;
        System.arraycopy(array, 0, arr.array, 0, array.length);
        for (int i = 0; i < c.length; i++) {
            arr.array[array.length + i] = c[i];
        }
        arr.size += c.length;
//        System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList(arr.array);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > size || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.array = new Object[array.length + c.length];
        arr.size = size;
        System.arraycopy(array, 0, arr.array, 0, index);
        for (int i = index; i < index + c.length; i++) {
            arr.array[i] = c[i - index];
        }
        for (int i = index; i < array.length; i++) {
            arr.array[i + c.length] = array[i];
        }
        arr.size += c.length;
//        System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList();
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > size || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.array = new Object[array.length - 1];
        arr.size = size;
        System.arraycopy(array, 0, arr.array, 0, array.length - 1);
        for (int i = index; i < array.length - 1; i++) {
            arr.array[i] = array[i + 1];
        }
        arr.size--;
//        System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList(arr.array);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > size || isEmpty()) {
            throw new InputMismatchException("Index out of range!");
        }
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.array = new Object[array.length];
        arr.size = size;
        System.arraycopy(array, 0, arr.array, 0, array.length);
        arr.array[index] = e;
//        System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList(arr.array);
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        for (Object k : array) {
            if (k == e) {
                System.out.println(i);
                return i;
            }
            i++;
        }
        System.out.println(-1);
        return -1;
    }

    @Override
    public int size() {
//        System.out.println(size);
        return size;
    }

    @Override
    public ImmutableList clear() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.array = new Object[0];
        arr.size = 0;
        System.arraycopy(array, 0 , arr.array, 0, arr.size);
        //System.out.println(Arrays.toString(arr.array));
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(array, 0, arr, 0, size);
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String args[]) {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.size();
//        arr.add(1, 4);
//        arr.add(0, -100);
//        arr.add(2, 400);
        arr.addAll(0, new Object[]{10, 100, 1000});
        arr.size();
        arr.addAll(new Object[]{20, 20, 40, 2000}).indexOf(40);
        arr.addAll(new Object[]{20, 20, 40, 2000}).indexOf(0);
        arr.set(0, "dfsdf");
//        arr.size();
//        arr.remove(1);
//        arr.toArray();
//        arr.clear();
        System.out.println(arr);

//        Object[] ar = new Object[10];
//        ar[0] = 0;
//        ar[1] = 1;
//        ar[2] = 2;
//        ar[3] = 3;
//        ar[4] = 4;
//        ar[5] = 5;
//        ar[6] = 6;
//        ar[7] = 7;
//        ar[8] = 8;
//        ar[9] = 9;
//        System.out.println(Arrays.toString(ar));
//        Object[] arr = new Object[15];
//        System.arraycopy(ar, 0, arr, 0, 5);
//        System.out.println(Arrays.toString(arr));
    }
}