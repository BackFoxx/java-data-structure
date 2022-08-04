package src.queue;

import src.stack.LinkedStack;

public class Palindrom {
    public static void main(String[] args) {
        System.out.println("Palindrom Check!");
        String str = "liononoil";
        boolean t = isPalindrom(str);
        System.out.println(str + " is Palindrom?: " + t);
    }

    private static boolean isPalindrom(String str) {
        LinkedStack<Character> s = new LinkedStack<>();
        LinkedQueue<Character> q = new LinkedQueue<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            s.push(c);
            q.enqueue(c);
        }
        for (int i = 0; i < str.length(); i++) {
            Character cha = s.pop();
            if (q.front() == cha) {
                q.dequeue();
            }
        }
        if (q.isEmpty()) return true;
        else return false;
    }
}
