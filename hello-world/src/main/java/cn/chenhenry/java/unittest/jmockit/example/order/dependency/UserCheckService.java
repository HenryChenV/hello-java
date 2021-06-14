package cn.chenhenry.java.unittest.jmockit.example.order.dependency;


/**
 * @author chenhanli
 * @date 2021/4/7 8:02 下午
 */
public interface UserCheckService {
    /**
     * 校验某个用户是否是合法用户
     *
     * @param userId
     *            用户ID
     * @return 合法的就返回true,否则返回false
     */
    public boolean check(long userId);
}
