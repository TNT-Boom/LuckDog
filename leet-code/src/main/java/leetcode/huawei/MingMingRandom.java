package leetcode.huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class MingMingRandom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            TreeSet<Integer> outPut = new TreeSet<>();
            for (int i = 0; i < n; ++i) {
                outPut.add(scanner.nextInt());
            }

            //			Integer[] outArrays = new Integer[outPut.size()];
            //			outPut.toArray(outArrays);
            for (Integer integer : outPut) {
                System.out.println(integer);
            }

        }
        scanner.close();
    }
}
