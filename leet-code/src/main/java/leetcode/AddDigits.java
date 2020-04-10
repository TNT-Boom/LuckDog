package leetcode;

import base.BaseAlgorithm;

public class AddDigits implements BaseAlgorithm {
    @Override
    public void runDemo() {
        System.out.println(addDigits(111));
    }

    private int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
