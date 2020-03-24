package cn.chenhenry.java.visitor.visitor;

import cn.chenhenry.java.visitor.element.Student;
import cn.chenhenry.java.visitor.element.Teacher;

public interface Visitor {

    void visit(Teacher teacher);

    void visit(Student student);

}
