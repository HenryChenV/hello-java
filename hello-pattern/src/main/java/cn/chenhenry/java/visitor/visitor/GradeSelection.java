package cn.chenhenry.java.visitor.visitor;

import cn.chenhenry.java.visitor.element.Student;
import cn.chenhenry.java.visitor.element.Teacher;

public class GradeSelection implements Visitor {

    private static final String AWARD_WORDS = "[%s]的分数是%d，荣获了成绩优秀奖。";

    @Override
    public void visit(Teacher teacher) {
        // 如果老师反馈得分超过85，则入围成绩优秀奖。
        if (teacher.getScore() >= 85) {
            System.out.println(String.format(AWARD_WORDS,
                    teacher.getName(), teacher.getScore()));
        }
    }

    @Override
    public void visit(Student student) {
        // 如果学生考试成绩超过90，则入围成绩优秀奖。
        if (student.getGrade() >= 90) {
            System.out.println(String.format(
                    AWARD_WORDS, student.getName(), student.getGrade()));
        }

    }

}
