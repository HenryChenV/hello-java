package cn.chenhenry.java.target;

/**
 * @author henrychen
 * @date created at 2020/10/9 4:46 下午
 */
public class UserServiceImpl implements IUserService {

    private String user = "henry";

    private String getUser() {
        return buildUser(user);
    }

    private String buildUser(String user) {
        return String.format("user[%s]", user);
    }

    private void setUser(String user) {
        this.user = user;
    }


    @Override
    public String select() {
        System.out.println("select " + getUser());
        return String.format("user[%s]", user);
    }

    @Override
    public void update(String user) {

        System.out.println("调用select >>>>>>>>>>>>>>>");
        this.select();
        System.out.println("调用select <<<<<<<<<<<<<<<<");

        System.out.println(String.format("update %s to %s", getUser(), buildUser(user)));
        setUser(user);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.select();
        userService.update("conke");
    }

}
