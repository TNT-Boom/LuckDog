package leetcode.find;

import org.junit.Test;

/**
 * @author limingjian
 * @date 2020/4/11
 *
 */
public class FindTest {
    @Test
    public void testFind(){
        int[] array = new int[]{1,5,6,7,4,3,9,8,2};
        FindKSequenceNum findKSequenceNum = new FindKSequenceNum();
        int res = findKSequenceNum.findKSeqNum(array, 0, 8, 1);
        System.out.println(res);
    }
}