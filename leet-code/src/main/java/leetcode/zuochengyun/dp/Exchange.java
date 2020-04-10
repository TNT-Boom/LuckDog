package leetcode.zuochengyun.dp;

/*
 * ����Ǯ����
 */
public class Exchange {
    static int[] source = new int[]{5, 10, 25, 1};
    static int[][] memResult;
    static int[][] origDpResult;

    public static void main(String[] args) {
        int a = 100;
        System.out.println(a);
        System.out.println(a++);
        System.out.println(++a);
        System.out.println(--a);
        System.out.println(a--);
        System.out.println(a + 1);
        System.out.println(a += 1);
        System.out.println(a);
        countWays(source, 4, 15);
    }

    public static int countWays(int[] penny, int n, int aim) {
        // ��������
        System.out.println(baoliExchange(source, 0, aim));

        // ��������
        // �����м���
        memResult = new int[n][aim + 1]; // [��ǰ��ʼIndex][��ǰ��Ҫ���ɵ�Ǯ��]����������붯̬�滮�ĺ��岻ͬ�������Զ����¡�
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < aim + 1; j++) {
                memResult[i][j] = -1;
            }
        }
        System.out.println(memSearch(penny, 0, aim));

        // ������̬�滮
        origDpResult = new int[n][aim + 1]; // ��ʾ����[0 ������index��Ǯ][��Ҫ��ɵ�Ǯ��]�������������ͬ������������¶��ϣ��涨�˼���˳��
        System.out.println(dpCount(penny, 0, aim));

        // �Ľ���Ķ�̬�滮
        origDpResult = new int[n][aim + 1]; // ��ʾ����[0 ������index��Ǯ][��Ҫ��ɵ�Ǯ��]�������������ͬ������������¶��ϣ��涨�˼���˳��
        System.out.println(advDpCount(penny, 0, aim));
        return 0;
    }

    // ��������
    // ���飬��ʼ������±꣬���ɵ���Ǯ��
    public static int baoliExchange(int[] penny, int index, int aim) {
        int total = 0;
        if (index == penny.length) {
            return aim == 0 ? 1 : 0;
        }
        int maxCount = aim / penny[index]; // ��������ɶ��ٵ�ǰ����Ǯ
        while (maxCount >= 0) // �ֱ�ʹ�� maxCount....0�ŵ�ǰ��Ǯ��ȥ����ʣ��ġ�
        {
            total += baoliExchange(penny, index + 1, aim - penny[index] * maxCount--);
        }
        return total;
    }

    // ������������������һ����ά�������Hash���¼�������ֵ��������˳�����⡣
    public static int memSearch(int[] penny, int index, int aim) {
        int total = 0;
        if (index == penny.length) {
            return aim == 0 ? 1 : 0;
        }
        if (memResult[index][aim] != -1) {
            return memResult[index][aim];
        }
        int maxCount = aim / penny[index];
        while (maxCount >= 0) {
            total += memSearch(penny, index + 1, aim - penny[index] * maxCount--);
        }
        return total;

    }

    // ��̬�滮�����κζ����Ż���
    public static int dpCount(int[] penny, int index, int aim) {
        // �ȳ�ʼ������
        // 0�� j�У�ֻ��j Ϊ penny[0]����������ʱ��ſ����з�����
        for (int j = 0; j < aim + 1; j++) {
            if (j % penny[0] == 0) {
                origDpResult[0][j] = 1;
            }
        }

        // ��ʼ���У�������0Ԫ���������еķ�������ֻ��һ�֣���0�š�
        for (int i = 0; i < penny.length; i++) {
            origDpResult[i][0] = 1;
        }

        // ���濪ʼ���㣬�������ص��Ե����ϵ�˼ά��
        // dp[i][j] ��ʾ penny[0��1��2��3����������i] ����Ǯ���j�ķ�������
        // ����dp[i][j] = d[i-1][j] + d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
        // �������������ά����
        for (int i = 1; i < penny.length; i++) // ��1��ʼ����Ϊ0���Ѿ���ʼ��
        {
            for (int j = 1; j < aim + 1; j++) {
                int total = 0;
                int count = j / penny[i]; // ���ȫ��j
                while (count >= 0) // �ֱ���count��i
                {
                    total += origDpResult[i - 1][j - penny[i] * count--];
                }
                origDpResult[i][j] = total;
            }
        }
        return origDpResult[penny.length - 1][aim];
    }

    // �ܽ���ɺ�Ķ�̬�滮
    // ���ٱ�����һ��
    public static int advDpCount(int[] penny, int index, int aim) {
        // �ȳ�ʼ������
        // 0�� j�У�ֻ��j Ϊ penny[0]����������ʱ��ſ����з�����
        for (int j = 0; j < aim + 1; j++) {
            if (j % penny[0] == 0) {
                origDpResult[0][j] = 1;
            }
        }

        // ��ʼ���У�������0Ԫ���������еķ�������ֻ��һ�֣���0�š�
        for (int i = 0; i < penny.length; i++) {
            origDpResult[i][0] = 1;
        }

        // ���濪ʼ���㣬�������ص��Ե����ϵ�˼ά��
        // dp[i][j] ��ʾ penny[0��1��2��3����������i] ����Ǯ���j�ķ�������
        // ����dp[i][j] = d[i-1][j] + d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
        // �������������ά����
        for (int i = 1; i < penny.length; i++) // ��1��ʼ����Ϊ0���Ѿ���ʼ��
        {
            for (int j = 1; j < aim + 1; j++) {
                // ���� d[i][j] = d[i-1][j] + d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
                // ��ô d[i][j - penny[i]] =   d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
                // ����ֱ���Ż�
                if (j - penny[i] >= 0) {
                    origDpResult[i][j] = origDpResult[i][j - penny[i]] + origDpResult[i - 1][j];
                } else {
                    origDpResult[i][j] = origDpResult[i - 1][j];
                }
            }
        }
        return origDpResult[penny.length - 1][aim];
    }
}
