package leetcode.zuochengyun.stackqueue;

import java.util.Stack;

public class GetMinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        data.push(node);
        if (node <= min) {
            min = node;
            mins.push(min);
        }

    }

    public void pop() {
        if (!data.isEmpty()) {
            if (data.pop() == mins.peek()) {
                mins.pop();
            }
        }
    }

    public int top() {
        if (data.isEmpty()) {
            return 0;
        }
        return data.peek();
    }

    public int min() {
        if (data.isEmpty() || mins.isEmpty()) {
            return 0;
        }
        return mins.peek();
    }
}
