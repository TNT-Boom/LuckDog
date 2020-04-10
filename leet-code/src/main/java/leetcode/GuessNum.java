package leetcode;

import base.BaseAlgorithm;

public class GuessNum implements BaseAlgorithm {
    @Override
    public void runDemo() {
        System.out.println(guessNumber(123));
    }

    private int guessNumber(int n) {
        int low = 0;
        int heigh = n;
        if (guess(n) == 0) {
            return n;
        }
        while (low < heigh) {
            int mid = heigh - (heigh - low) / 2;
            int res = guess(mid);
            if (res == -1) {
                heigh = mid;
            } else if (res == 1) {
                low = mid;
            } else {
                return mid;
            }
        }

        return heigh;
    }

    private int guess(int num) {
        if (num < 10) {
            return 1;
        } else if (num > 10) {
            return -1;
        } else {
            return 0;
        }
    }
}
