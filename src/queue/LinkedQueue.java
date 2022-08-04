package src.queue;

import src.list.Node;

public class LinkedQueue<E> implements QueueInterface<E> {
    private Node<E> tail;
    private final E ERROR = null;

    public LinkedQueue() {
        tail = null;
    }

    @Override
    public void enqueue(E newItem) {
        Node<E> newNode = new Node(newItem);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR; /* 에러! */
        } else {
            E tailItem = tail.item;
            if (tail.next == tail) {
                tail = null;
            } else {
                Node<E> frontNode = tail.next;
                tail.next = frontNode.next;
            }
            return tailItem;
        }
    }

    @Override
    public E front() {
        if (isEmpty()) return ERROR; /* 에러! */
        return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void dequeueAll() {
        tail = null;
    }
}
