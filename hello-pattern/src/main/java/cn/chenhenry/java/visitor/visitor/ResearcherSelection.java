package cn.chenhenry.java.visitor.visitor;

import cn.chenhenry.java.visitor.element.Student;
import cn.chenhenry.java.visitor.element.Teacher;

public class ResearcherSelection implements Visitor {
    private static final String AWARD_WORDS = "[%s]的论文数是%d，荣获了科研优秀奖。";

    @Override
    public void visit(Teacher teacher) {
        // 如果老师发表论文数超过8，则入围科研优秀奖。
        if(teacher.getPaperCount() > 8){
            System.out.println(String.format(AWARD_WORDS,
                    teacher.getName(),teacher.getPaperCount()));
        }
    }

    @Override
    public void visit(Student student) {
        // 如果学生发表论文数超过2，则入围科研优秀奖。
        if(student.getPaperCount() > 2){
            System.out.println(String.format(AWARD_WORDS,
                    student.getName(),student.getPaperCount()));
        }
    }
}
