package cn.chenhenry.java;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8294180014912103005L;

    private String username;
    private transient String password;

}
