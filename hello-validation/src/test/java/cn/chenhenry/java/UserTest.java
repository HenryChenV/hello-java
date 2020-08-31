package cn.chenhenry.java;

import com.sun.xml.internal.ws.assembler.jaxws.ValidationTubeFactory;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author henrychen
 * @date created at 2020/8/28 3:05 下午
 */
public class UserTest {

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(v -> {
            System.out.println(v.getMessage());
        });
    }

}