package com.limingjian.jvmlearn;

/*
 * 测试虚拟机栈与本地方法栈溢出
 * 参数 -Xss2M // 栈越大则多线程越容易爆内存
 * 抛L outofmemory 异常
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    dontStop();

                }
            });
            thread.start();
        }
    }
}
