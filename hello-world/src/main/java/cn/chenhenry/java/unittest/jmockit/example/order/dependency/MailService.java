package cn.chenhenry.java.unittest.jmockit.example.order.dependency;


/**
 * @author chenhanli
 * @date 2021/4/7 8:01 下午
 */
public interface MailService {
    /**
     * 发送邮件
     *
     * @param userId
     *            邮件接受人id
     * @param content
     *            邮件内容
     * @return 发送成功了，就返回true,否则返回false
     */
    public boolean sendMail(long userId, String content);
}
