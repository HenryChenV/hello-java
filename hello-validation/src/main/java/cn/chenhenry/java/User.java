package cn.chenhenry.java;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.util.List;

/**
 * @author henrychen
 * @date created at 2020/8/28 3:02 下午
 */
@Data
public class User {
    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200, message
            = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

//    @NonNull
//    List<@NotBlank String> preferences;

    public User() {

    }
}
