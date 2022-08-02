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
    }
}
