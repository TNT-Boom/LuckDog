package com.limingjian.jvmlearn;

import java.util.ArrayList;
import java.util.List;

public class JHeapOutMem {
    /*
     * 测试堆溢出，JVM参数：
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    static class OOMObject {}

    private static List<OOMObject> list = new ArrayList<>();

    public static void OutOfMem() {
        while (true) {
            list.add(new OOMObject());
        }
    }
}
