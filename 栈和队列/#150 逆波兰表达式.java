package StackAndList;

import java.util.Deque;
import java.util.LinkedList;

public class Polan {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        int a,b;
        for(String i: tokens){
            if (i.equals("+")||i.equals("-")||i.equals("*")||i.equals("/")){
                b = deque.pop();
                a = deque.pop();
                if (i.equals("+"))deque.push(a+b);
                else if (i.equals("-"))deque.push(a-b);
                else if (i.equals("*"))deque.push(a*b);
                else if (i.equals("/"))deque.push(a/b);
            }
            else {
                deque.push(Integer.parseInt(i));
            }
        }
        return deque.pop();
    }
}
