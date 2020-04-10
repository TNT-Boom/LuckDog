package com.limingjian.jvmlearn;

import java.util.ArrayList;
import java.util.List;

/*
 * 爆运行时常量池内存
 * JVM参数： -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 1.6才可以，1.7则由于intern方法不再拷贝到Perm区，所以不会爆
 */
public class RuntimeConstantPoolOOM {
    public static void outMem() {
        int i = 0;
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
