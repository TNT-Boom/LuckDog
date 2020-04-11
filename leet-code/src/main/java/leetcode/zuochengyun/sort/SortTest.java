package leetcode.zuochengyun.sort;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author limingjian
 * @date 2020/4/11
 *
 */
public class SortTest {
    @Test
    public void testSort(){
        int[] array = new int[]{5,4,3,5, 6,9,7,2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}