package StackAndList;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    /** initialize your data structure here. */
    Deque<Integer> minStack;
    Deque<Integer> xStack;

    public MinStack() {
        minStack = new LinkedList<>();
        xStack = new LinkedList<>();
        xStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        minStack.push(x);
        xStack.push(Math.min(xStack.peek(), x));
    }

    public void pop() {
        minStack.pop();
        xStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return xStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(12);
        System.out.println(obj.top());
    }
}
