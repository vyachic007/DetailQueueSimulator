package by.slava_borisov.lab1;

public interface Queue {
    void init();

    boolean enqueue(Detail item);

    Detail dequeue();

    boolean isEmpty();

    boolean isFull();

    Detail[] toArray();
}
