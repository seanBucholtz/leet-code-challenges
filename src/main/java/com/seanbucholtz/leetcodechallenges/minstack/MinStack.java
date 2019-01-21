package com.seanbucholtz.leetcodechallenges.minstack;

class MinStack {

    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Integer min;
    private int size;

    /** initialize your data structure here. */
    public MinStack() {
        this.head = null;
        this.min = null;
    }

    public void push(int x) {
        this.head = new Node(x, null, this.head);
        if(this.head.next != null) {
            this.head.next.prev = this.head;
        }

        this.size ++;

        if(this.min == null || x < this.min) {
            this.min = x;
        }
    }

    public void pop() {
        if(this.head != null) {
            if(this.head.next != null) {
                this.head.next.prev = null;
                this.min = MinStack.findMinimum(this.head.next, this.min == this.head.value ? null : this.min);
            }
            else {
                this.min = null;
            }
            this.head = head.next;
            this.size --;
        }
    }

    public int top() {
        if(this.head == null) {
            throw new RuntimeException("Stack is empty.");
        }
        return this.head.value;
    }

    public int getMin() {
        return this.min;
    }

    public int size() {
        return this.size;
    }

    private static int findMinimum(Node node, Integer minimum) {
        if(node == null) {
            return minimum;
        }
        if(minimum == null || node.value < minimum) {
            minimum = node.value;
        }
        return findMinimum(node.next, minimum);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
