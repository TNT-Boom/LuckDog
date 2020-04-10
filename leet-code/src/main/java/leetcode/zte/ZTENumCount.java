package leetcode.zte;

public class ZTENumCount {
    public static void main(String[] args) {
        numCount(0, 1230);
    }

    private static void numCount(int num, int bigNum) {
        StringBuilder sourceString = new StringBuilder();
        while (bigNum != 0) {
            sourceString.append(bigNum % 10);
            bigNum = bigNum / 10;
        }

        int count = 0;
        StringBuilder numStr = new StringBuilder();
        numStr.append(num);
        for (int i = 0; i < sourceString.toString().length(); ++i) {
            if (numStr.toString().charAt(0) == sourceString.toString().charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
