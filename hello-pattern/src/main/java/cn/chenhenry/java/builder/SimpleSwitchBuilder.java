package cn.chenhenry.java.builder;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现一个builder
 * ref: https://weblogs.asp.net/arturtrosin/builder-pattern-through-fluent-interface?spm=ata.13261165.0.0.f06256d2A1m7Bm
 */

enum EnumType {
    ONE,
    TWO,
    THREE,
    FOUR,
    ;
}

@FunctionalInterface
interface Action {
    void doIt();
}


interface IDo {
    void Do();
}

interface IBody extends IDo {
    ICase Case(Object obj);
    IDefault Default();
}

interface ICase {
    ICase Case(Object obj);
    IBody Body(Action action);
}

interface IDefault {
    IDo DefBody(Action action);
}

interface ISwitch {
    ICase Case(Object obj);
}

interface IDefBody extends IDo {
}

interface IBuilder {
    ISwitch Switch(Object obj);
}


public class SimpleSwitchBuilder implements IBuilder, ISwitch, ICase, IBody, IDefault, IDefBody {

    private Action defaultAction;
    private Object testObject;
    private List<Object> caseList;
    private Map<Object, Action> caseActions = new HashMap<>();

    public SimpleSwitchBuilder() {}

    public static IBuilder Builder() {
        return new SimpleSwitchBuilder();
    }

    @Override
    public ISwitch Switch(Object obj) {
        caseList = new ArrayList<>();
        testObject = obj;
        return this;
    }

    @Override
    public ICase Case(Object obj) {
        caseList.add(obj);
        return this;
    }

    @Override
    public IBody Body(Action action) {
        for (Object obj : caseList) {
            caseActions.put(obj, action);
        }
        caseList.clear();
        return this;
    }

    @Override
    public IDefault Default() {
        return this;
    }

    @Override
    public IDo DefBody(Action action) {
        defaultAction = action;
        return this;
    }

    @Override
    public void Do() {
        for (Map.Entry<Object, Action> entry : caseActions.entrySet()) {
            if (entry.getKey().equals(testObject)) {
                entry.getValue().doIt();
                return;
            }
        }

        if (defaultAction != null) {
            defaultAction.doIt();
        }
    }

    private static void testCase(EnumType state) {
        SimpleSwitchBuilder.Builder()
                .Switch(state)
                .Case(EnumType.ONE)
                .Body(() -> {
                    System.out.println("this is ONE");
                })
                .Case(EnumType.TWO)
                .Case(EnumType.THREE)
                .Body(() -> {
                    System.out.println("this is TWO or THREE");
                })
                .Default()
                .DefBody(() -> {
                    System.out.println("this is default");
                })
                .Do();
        ;
    }

    public static void main(String[] args) {
        testCase(EnumType.ONE);
        testCase(EnumType.TWO);
        testCase(EnumType.THREE);
        testCase(EnumType.FOUR);
    }
}
