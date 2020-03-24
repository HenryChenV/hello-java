package cn.chenhenry.java.visitor.element;

import cn.chenhenry.java.visitor.visitor.Visitor;

public interface Element {

    /**
     * 接受一个访问者访问
     * @param visitor
     */
    void accept(Visitor visitor);

}
