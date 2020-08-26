package cn.chenhenry.java;

import org.junit.Test;

import java.io.*;


public class StaticUserTest {

    @Test
    public void testTransient() {
        String filePath = "/tmp/testUser.txt";

        StaticUser user = new StaticUser();
        user.setUsername("Henry");
        user.setPassword("123456");

        System.err.println("read before Serializable: ");
        System.err.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPassword());

        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(filePath)
            );
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            StaticUser.setUsername("conke");
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
            user = (StaticUser) is.readObject();
            is.close();

            System.err.println("\nread  after Serializable: ");
            System.err.println("username: " + user.getUsername());
            System.err.println("password: " + user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}