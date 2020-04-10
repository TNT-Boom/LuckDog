package leetcode.zuochengyun.stackqueue;

import java.util.Stack;

public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        if (A == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(A[i]);
        }
        reverse(stack);
        for (int i = 0; i < n; i++) {
            A[i] = stack.pop();
        }
        return A;
    }


    public int get(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = stack.pop();
        reverse(stack);
        stack.push(i);
    }
}
