class MyQueue {
    int x;
    Deque<Integer> deque = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        deque.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return deque.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        int tmp = deque.removeFirst();
        deque.push(tmp);
        return tmp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */