package src.list;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0, 300);
        arrayList.add(0, 200);
        arrayList.add(0, 100);
        arrayList.append(500);
        arrayList.append(600);
        arrayList.remove(3);
        arrayList.add(3, 250);
        arrayList.add(1, 50);
        arrayList.add(0, 10);
        arrayList.append(700);
        arrayList.remove(1);
        arrayList.removeItem(600);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 300);
        linkedList.add(0, 200);
        linkedList.add(0, 100); //1

        linkedList.append(500);
        linkedList.append(600); //2

        linkedList.remove(3); //3

        linkedList.add(3, 250);
        linkedList.add(1, 50);
        linkedList.add(0, 10); //4

        linkedList.append(700);

        linkedList.remove(1);
        linkedList.removeItem(600);
    }
}
