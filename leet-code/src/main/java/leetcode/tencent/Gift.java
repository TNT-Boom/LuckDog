package leetcode.tencent;

import java.util.HashMap;
import java.util.Map;

/***
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
若没有金额超过总数的一半，返回0。
 */
public class Gift {
    public static void main(String[] args) {
        System.out.println(getValue(new int[]{5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297,
                5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 5297, 2174, 4144, 5386, 3224, 1711, 8887, 6693, 2679,
                6655, 6404, 9485, 3724, 7696, 1308, 6413, 2701, 7585, 2391, 6193, 1645, 2077, 5970, 3988, 3132, 8402, 4179,
                4915, 9164, 1461, 1948, 8902, 1563, 4163, 5841, 4432, 573, 3819, 2157, 4500, 5961, 6523, 9154, 6619, 1144,
                824, 6527, 4819, 153, 5570, 1287, 5322, 2009, 1959, 5472, 8908, 8721, 7462, 2537, 1657, 3376, 1207, 1248,
                2011, 7290, 3385, 66, 6614, 1441, 5516, 4084, 3616, 1779, 4753, 3202, 9011, 1493, 2895, 38, 2369, 8575,
                6519, 8763, 3528, 247, 4153, 8706, 1238, 4114, 7800, 4549, 7918, 5448, 6428, 5882, 6155, 6647, 7223, 1163,
                933, 9787, 1419, 8387, 6610, 1245, 9593, 6459, 4958, 2537, 7101, 4919, 1406, 5285, 3272, 1722, 2130, 8895,
                6925, 7377, 5129, 4422, 577, 1535, 697, 4268, 5885, 3300, 1647, 6265, 6741, 3059, 1028, 7347, 670, 1988,
                2609, 5166, 1276, 887, 5700, 4287, 2233, 8523, 9139, 3461, 653, 1118, 2624, 4425, 8602, 9157, 1918, 1685,
                7863, 2702, 7172, 4804, 8400, 756, 4287, 4169, 7756, 2035, 716, 7474, 8015, 3309, 1766, 6814, 9248, 1868,
                8813, 8364, 4381, 6937, 9960, 8742, 2702, 4093, 5612, 3230, 3112, 3222, 7805, 2104, 3715, 1307, 6388, 2569,
                5630, 3171, 5362, 3614, 9762, 2259, 149, 2991, 6564, 5047, 2488, 853, 2174, 1604, 4815, 9706, 768, 4987,
                7588, 6464, 4371, 1840, 9099, 1173, 4447, 251, 1709, 8806, 8638, 1262, 7571, 850, 2064, 2505, 5489, 9248,
                4240, 251, 2422, 1106, 6727, 3098, 9744, 1644, 5167, 181, 1637, 5488, 8682, 8999, 3999, 3356, 901, 8974,
                8504, 199, 2199, 6893, 3575, 151, 2350, 4367, 9049, 1783}, 508));
    }

    public static int getValue(int[] gifts, int n) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        if (gifts == null) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (result.containsKey(gifts[i])) {
                result.put(gifts[i], result.get(gifts[i]) + 1);
            } else {
                result.put(gifts[i], 1);
            }
        }
        int maxCount = -1;
        int index = -1;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                index = entry.getKey();
            }

        }
        if (index == -1) {
            return 0;
        }
        if (maxCount < n / 2) {
            return 0;
        } else {
            return index;
        }
    }
}
