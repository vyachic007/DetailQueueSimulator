package by.slava_borisov.lab1.array;

import by.slava_borisov.lab1.Detail;
import by.slava_borisov.lab1.Queue;

public class ArrayQueue implements Queue {

    private static final int CAPACITY = 5;
    private Detail[] element = new Detail[CAPACITY];
    private int head;
    private int tail;
    private int size;

    @Override
    public void init() {
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public boolean enqueue(Detail item) {
        if (isFull()) {
            return false;
        }
        element[tail] = item;
        tail = (tail + 1) % CAPACITY;
        size++;
        return true;
    }

    @Override
    public Detail dequeue() {
        if (isEmpty()) {
            return null;
        }
        Detail item = element[head];
        head = (head + 1) % CAPACITY;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }

    @Override
    public Detail[] toArray() {
        Detail[] result = new Detail[size];
        for (int i = 0; i < size; i++) {
            result[i] = element[(head + i) % CAPACITY];
        }
        return result;
    }
}