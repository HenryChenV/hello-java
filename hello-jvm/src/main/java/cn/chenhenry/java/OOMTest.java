package cn.chenhenry.java;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    static class OOMObject {
        public byte[] obj = new byte[64 * 1024];
    }
    public static void main(String[] args) {
        heapError(Integer.MAX_VALUE);
    }

    public static void heapError(int floor) {
        List<OOMObject> oomObjects = new ArrayList<>();

        for (int i = 0; i < floor; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            oomObjects.add(new OOMObject());
            System.out.println("new object i=" + i);
        }
    }
}
