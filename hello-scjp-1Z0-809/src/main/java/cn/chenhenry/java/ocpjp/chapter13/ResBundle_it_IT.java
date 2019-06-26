package cn.chenhenry.java.ocpjp.chapter13;

public class ResBundle_it_IT {
    public Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            { "MovieName", "Che Bella Giornata" },
            { "GrossRevenue", (Long) 43000000L }, // in euros
            { "Year", (Integer)2011 }
    };
}
