package org.example.g1;

import java.util.LinkedList;

public class Test {
    private static final LinkedList<String> strings = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 10; j++) {
                    strings.add(new String("String " + j));
                }
            }
            Thread.sleep(100);
        }
    }
}
//        通过命令设置参数，如下所示：
//       -Xmx128M
//       -XX:+UseG1GC
//       -XX:+PrintGCDetails
//       -XX:+PrintGCTimeStamps
//       -XX:+PrintTLAB
//       -XX:+UnlockExperimentalVMOptions
//       -XX:G1LogLevel=finest
