package base;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        Map<Integer, String> algrithmMap = new HashMap<Integer, String>() {
            /**
             * serialVersionUID
             */
            private static final long serialVersionUID = 1L;

            {
                put(221, "DoubleMatrix");
                put(208, "Trie");
                put(372, "SuperPow");
                put(374, "GuessNum");
                put(345, "ReverseVowelsString");
                put(145, "PostordertTraversal");
                put(373, "FindKPairsWithSmallestSums");
                put(371, "SumOfTwoInt");
                put(258, "AddDigits");
                put(292, "NimGame");
                put(1, "TwoSum");
                put(2, "AddTwoNumbers");
                put(310, "MHT");
                put(340, "ReverseString");
                put(341, "HeapSort");

                put(901, "SpliteGround");
                put(902, "QuickSort");
                put(903, "BubbleSort");
                put(904, "SubStringHan");
                put(905, "tree.MinHeapMain");
                put(906, "DPSteel");

                put(1001, "CvteTest");

                put(2001, "EncryptTestify");
                put(2002, "StatisticFood");
            }
        };
        String prefix = "leetcode.";
        try {
            int algrithmIndex = 1;
            Class<?> algrithm = Class.forName(prefix + algrithmMap.get(algrithmIndex));
            BaseAlgorithm baseAlgorithm = (BaseAlgorithm) algrithm.newInstance();
            baseAlgorithm.runDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}