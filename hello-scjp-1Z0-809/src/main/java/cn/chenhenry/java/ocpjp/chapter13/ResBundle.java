package cn.chenhenry.java.ocpjp.chapter13;

import java.util.ListResourceBundle;

public class ResBundle extends ListResourceBundle {
    static final Object[][] contents = {
            {"MovieName", "Avatar"},
            {"GrossRevenue", 2782275172L},
            {"Year", 2009}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
