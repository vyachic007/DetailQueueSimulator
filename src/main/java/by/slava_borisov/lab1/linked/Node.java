package by.slava_borisov.lab1.linked;

import by.slava_borisov.lab1.Detail;

public class Node {
    public Detail data;
    public Node next;

    public Node(Detail data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
