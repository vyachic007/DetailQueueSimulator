package by.slava_borisov.lab1.array;

import by.slava_borisov.lab1.Detail;
import by.slava_borisov.lab1.Queue;

public class ArrayQueue implements Queue {

    private Detail[] element = new Detail[5];
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
        if (size == element.length) {
            return false;
        }
        element[tail] = item;
        tail = (tail + 1) % element.length;
        size++;
        return true;
    }

    @Override
    public Detail dequeue() {
        if (size == 0) {
            return null;
        }
        Detail item = element[head];
        head = (head + 1) % element.length;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == element.length;
    }

    @Override
    public Detail[] toArray() {
        Detail[] result = new Detail[size];
        for (int i = 0; i < size; i++) {
            result[i] = element[(head + i) % element.length];
        }
        return result;
    }
}
