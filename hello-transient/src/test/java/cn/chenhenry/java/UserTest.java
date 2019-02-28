package cn.chenhenry.java;


import org.junit.Test;

import java.io.*;

public class UserTest {

    @Test
    public void testTransient() {
        String filePath = "/tmp/testUser.txt";

        User user = new User();
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
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
            user = (User) is.readObject();
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