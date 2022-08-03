package src.stack;

public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(300);
        arrayStack.push(200);
        arrayStack.push(100);
        arrayStack.pop();

        LinkedStack<Object> linkedStack = new LinkedStack<>();
        linkedStack.push("test 1");
        linkedStack.push("test 2");
        linkedStack.push("test 3");
        linkedStack.pop();
    }
}
