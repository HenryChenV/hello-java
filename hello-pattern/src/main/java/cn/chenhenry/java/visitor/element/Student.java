package cn.chenhenry.java.visitor.element;

import cn.chenhenry.java.visitor.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Element {

    /**
     * name
     */
    private String name;
    /**
     * 成绩
     */
    private int grade;
    /**
     * 论文数
     */
    private int paperCount;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
