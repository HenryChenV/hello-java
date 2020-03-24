package cn.chenhenry.java.visitor.element;

import cn.chenhenry.java.visitor.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 具体元素, 允许visitor访问本对象的数据结构
 */
@Data
@AllArgsConstructor
public class Teacher implements Element {

    /**
     * name
     */
    private String name;
    /**
     * 评价分数
     */
    private int score;
    /**
     * 论文数
     */
    private int paperCount;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
