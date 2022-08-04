package src.queue;

public class Test {
    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue("test 1");
        arrayQueue.enqueue("test 2");
        arrayQueue.enqueue("test 3");
        arrayQueue.dequeue();
    }
}
