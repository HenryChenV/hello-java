package cn.chenhenry.java;

import lombok.Data;

import java.io.Serializable;

@Data
public class StaticUser implements Serializable {

    private static final long serialVersionUID = 8294180014912103005L;

    public static String username;
    private transient String password;

    public static void setUsername(String username) {
        StaticUser.username = username;
    }

    public static String getUsername() {
        return username;
    }

}
