package com.seanbucholtz.leetcodechallenges.stackusingqueues;

import java.util.concurrent.ConcurrentLinkedQueue;

class MyStack {

    private enum OperationType {
        PEEK,
        POP
    }

    private ConcurrentLinkedQueue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.getLast(OperationType.POP);
    }

    /** Get the top element. */
    public int top() {
        return this.getLast(OperationType.PEEK);
    }

    private int getLast(OperationType operationType) {
        if(this.queue.isEmpty()) {
            // prevents this method from throwing a NullPointerException
            throw new RuntimeException("Stack is empty");
        }
        ConcurrentLinkedQueue<Integer> tempQueue = new ConcurrentLinkedQueue<>();
        Integer rtnVal = null;
        while(!this.queue.isEmpty()) {
            rtnVal = this.queue.poll();
            if((operationType == OperationType.POP && this.queue.size() > 0)
                    || operationType == OperationType.PEEK) {
                tempQueue.add(rtnVal);
            }
        }
        this.queue = tempQueue;
        return rtnVal;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
