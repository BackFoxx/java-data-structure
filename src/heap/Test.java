package src.heap;

public class Test {
    public static void main(String[] args) {
        Heap<Integer> h = new Heap(5);

        try {
            h.insert(1);
            h.insert(10);
            h.clear();

            h.insert(30);
            h.insert(10);
            h.insert(30);
            h.insert(20);
            h.insert(40);

            h.deleteMax();
            h.insert(1);
            h.insert(3);
            h.deleteMax();
        } catch (Exception e) {
            System.out.println("에러났당");
            e.printStackTrace();
        }
    }
}
