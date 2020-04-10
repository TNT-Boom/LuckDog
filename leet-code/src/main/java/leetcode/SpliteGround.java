package leetcode;

import base.BaseAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpliteGround implements BaseAlgorithm {
    private final static int MAXN = 75;
    private final static int MAXM = 75;
    private static int[][] sum = new int[MAXN][MAXM];
    private static int n = 0;
    private static int m = 0;
    private static int t1 = 0;
    private static int t2 = 0;

    public void runDemo() {
        demo();
    }

    public void demo() {
        int[][] a = new int[MAXN][MAXM];

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String lineStr;
        try {
            int inCount = 0;
            while ((lineStr = input.readLine()) != null) {
                if (lineStr.equals(" ")) {
                    break;
                }
                if (inCount == 0) {
                    String[] nm = lineStr.split(" ");
                    n = Integer.parseInt(nm[0]);
                    m = Integer.parseInt(nm[1]);
                    t1 = 4;
                    t2 = 4;
                } else {
                    char[] aArray = lineStr.toCharArray();
                    for (int j = 0; j < m; j++) {
                        a[inCount - 1][j] = Integer.parseInt(aArray[j] + "");
                    }
                }
                ++inCount;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum[i][j] = sum[i - 1][j] + a[i][j];
                }
            }

            int l = 1, r = 1, ans = 0;
            for (int j = 1; j <= m; j++) {
                r += sum[n][j];
            }

            for (int i = 1; i <= 60; i++) {
                int m_ = (l + r) / 2;
                if (is_ok_(m_)) {
                    l = ans = m_;
                } else {
                    r = m_;
                }
            }
            System.out.println(ans);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    boolean is_ok(int l, int r, int _m) {
        int tot = 0, p = 0;
        for (int i = 1; i <= m; i++) {
            tot += sum[r][i] - sum[l - 1][i];
            if (tot >= _m) {
                tot = 0;
                p++;
            }
        }
        if (p >= t2) {
            return true;
        } else {
            return false;
        }
    }

    boolean is_ok_(int _m) {
        int p = 0, l = 1;
        for (int i = 1; i <= n; i++) {
            if (is_ok(l, i, _m)) {
                l = i + 1;
                p++;
            }
        }
        if (p >= t1) {
            return true;
        } else {
            return false;
        }
    }
}
