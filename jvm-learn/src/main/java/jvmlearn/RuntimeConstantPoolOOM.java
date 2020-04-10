package com.limingjian.jvmlearn;

import java.util.ArrayList;
import java.util.List;

/*
 * ������ʱ�������ڴ�
 * JVM������ -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 1.6�ſ��ԣ�1.7������intern�������ٿ�����Perm�������Բ��ᱬ
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
