package leetcode.huawei;

import java.util.Scanner;

public class NearlyInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double input = scanner.nextDouble();
            System.out.println((int) (input + 0.5));
        }
        scanner.close();
    }
}
