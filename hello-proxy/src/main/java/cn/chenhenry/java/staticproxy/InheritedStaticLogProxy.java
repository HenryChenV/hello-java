package cn.chenhenry.java.staticproxy;

import cn.chenhenry.java.target.IUserService;
import cn.chenhenry.java.target.UserServiceImpl;

/**
 * @author henrychen
 * @date created at 2020/10/9 4:48 下午
 */
public class InheritedStaticLogProxy extends UserServiceImpl {

    @Override
    public String select() {
        System.out.println(getClass() + " log before select");

        String ret = super.select();

        System.out.println(getClass() + " log after select");

        return ret;
    }

    @Override
    public void update(String user) {
        System.out.println(getClass() + " log before update");

        super.update(user);

        System.out.println(getClass() + " log after update");
    }

    public static void main(String[] args) {
        IUserService proxy = new InheritedStaticLogProxy();

        proxy.select();
        proxy.update("conke");
    }
}
