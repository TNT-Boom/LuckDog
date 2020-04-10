package junitest.leecode.zuochengyun.stackqueue;

import leetcode.zuochengyun.stackqueue.GetMinStack;
import org.junit.Before;
import org.junit.Test;

public class GetMinStackTest {
    GetMinStack getMinStack;

    @Before
    public void setUp()
            throws Exception {
        getMinStack = new GetMinStack();
    }

    @Test
    public void testUseCase() {
        getMinStack.push(3);
        getMinStack.min();
        getMinStack.push(4);
        getMinStack.min();
        getMinStack.push(2);
        getMinStack.min();
        getMinStack.push(3);
        getMinStack.min();
        getMinStack.pop();
        getMinStack.min();
        getMinStack.pop();
        getMinStack.min();
        getMinStack.pop();
        getMinStack.min();
        getMinStack.push(0);
        getMinStack.min();
    }

}
