package leetcode.zte;
/*
 * 1*2*3*4*17*18*19*20
 * --5*6*7*14*15*16
 * ----8*9*12*13
 * ------10*11
 *
 * 1*2*3*4*5*26*27*28*29*30
 * --6*7*8*9*22*23*24*25
 * ----10*11*12*19*20*21
 * ------13*14*17*18
 * --------15*16
 */

import java.util.ArrayList;

public class ZTETraShape {
    public static void main(String[] args) {
        printTraShap(5);
    }

    public static void printTraShap(int n) {
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
        int topNum = 0;
        int globalNum = 1;
        for (int i = 0; i < n; i++) {
            topNum += 2 + i;
        }


        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int _count = 2 * i;
            while (_count-- != 0) {
                builder.append("-");
            }
            int numCount = n - i;
            while (numCount-- != 0) {
                builder.append(globalNum++);
            }
            result.add(builder);
        }

        for (int i = n - 1; i >= 0; i--) {
            int numCount = n - i;
            while (numCount-- != 0) {
                result.get(i).append(globalNum++);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }
}
