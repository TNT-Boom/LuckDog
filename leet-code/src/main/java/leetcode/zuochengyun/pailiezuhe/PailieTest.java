package leetcode.zuochengyun.pailiezuhe;

import org.junit.Test;

/**
 * @author limingjian
 * @date 2020/4/13
 *
 */
public class PailieTest {
    @Test
    public void TestPailie() {
        AllPailie allPailie = new AllPailie();
        char[] base = new char[]{'1', '1', '1'};
        allPailie.Permutation(base, 0);
    }
}