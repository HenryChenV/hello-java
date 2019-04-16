package cn.chenhenry.java.ocpjp.chapter9.exam;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream findings = new FileInputStream("log.txt");
        DataInputStream dataStream = new DataInputStream(findings);
        dataStream.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(dataStream));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
