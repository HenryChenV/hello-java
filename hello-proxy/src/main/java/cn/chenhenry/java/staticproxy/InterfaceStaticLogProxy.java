package cn.chenhenry.java.staticproxy;

import cn.chenhenry.java.target.IUserService;
import cn.chenhenry.java.target.UserServiceImpl;

/**
 * @author henrychen
 * @date created at 2020/10/9 4:49 下午
 */
public class InterfaceStaticLogProxy implements IUserService {

    private final IUserService target;

    public InterfaceStaticLogProxy(IUserService userService) {
        this.target = userService;
    }

    @Override
    public String select() {
        System.out.println(getClass() + " log before select");

        String ret = target.select();

        System.out.println(getClass() + " log after select");

        return ret;
    }

    @Override
    public void update(String user) {
        System.out.println(getClass() + "log before update");

        target.update(user);

        System.out.println(getClass() + " log after update");
    }

    public static void main(String[] args) {
        IUserService proxy = new InterfaceStaticLogProxy(new UserServiceImpl());

        proxy.select();
        proxy.update("conke");
    }

}
