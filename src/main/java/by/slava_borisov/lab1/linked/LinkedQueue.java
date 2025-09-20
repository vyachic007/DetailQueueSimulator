package by.slava_borisov.lab1.linked;

import by.slava_borisov.lab1.Detail;
import by.slava_borisov.lab1.Queue;

public class LinkedQueue implements Queue {

    private Node head;
    private Node tail;

    @Override
    public void init() {
        head = null;
        tail = null;
    }

    @Override
    public boolean enqueue(Detail item) {
        Node newNode = new Node(item);
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = tail;
        return true;
    }

    @Override
    public Detail dequeue() {
        if (head == null) return null;
        Detail item = head.data;
        head = head.next;
        if (head == null) tail = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Detail[] toArray() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        Detail[] result = new Detail[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
}
