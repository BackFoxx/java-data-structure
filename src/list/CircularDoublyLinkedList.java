package src.list;

public class CircularDoublyLinkedList<E> implements ListInterface<E> {
    private BidirectionalNode<E> head;
    private int numItems;

    public CircularDoublyLinkedList() {
        numItems = 0;
        head = new BidirectionalNode<>(null);
        head.next = head.prev = head;
    }

    @Override
    public void add(int index, E x) {
        if (index >= 0 && index <= numItems) {
            BidirectionalNode<E> prevNode = getNode(index - 1);
            BidirectionalNode newNode = new BidirectionalNode(prevNode, x, prevNode.next);
            prevNode.next = newNode;
            newNode.next.prev = newNode;
            numItems++;
        }
    }

    @Override
    public void append(E x) {
        BidirectionalNode<E> prevNode = head.prev;
        BidirectionalNode newNode = new BidirectionalNode(prevNode, x, head);
        prevNode.next = newNode;
        head.prev = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            BidirectionalNode<E> curNode = getNode(index);
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            --numItems;
            return curNode.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeItem(E x) {
        BidirectionalNode<E> curNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            curNode = curNode.next;
            if (((Comparable) (curNode.item)).compareTo(x) == 0) {
                curNode.prev.next = curNode.next;
                curNode.next.prev = curNode.prev;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else {
            return null;
        }
    }

    @Override
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = x;
        } else {
            /* 에러 */
        }
    }

    public static final int NOT_FOUNT = -12345;
    @Override
    public int indexOf(E x) {
        BidirectionalNode<E> curNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            curNode = curNode.next;
            if (((Comparable) (curNode.item)).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUNT;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head.next = head.prev = head;
    }

    private BidirectionalNode<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = head;
            if (index < numItems / 2) {
                for (int i = 0; i <= index; i++) {
                    currNode = currNode.next;
                }
                return currNode;
            } else {
                for (int i = numItems - 1; i >= index; i--) {
                    currNode = currNode.prev;
                }
                return currNode;
            }
        } else {
            return null;
        }
    }
}
