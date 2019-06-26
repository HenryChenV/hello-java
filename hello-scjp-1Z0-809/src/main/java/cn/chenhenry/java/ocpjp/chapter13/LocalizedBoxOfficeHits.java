package cn.chenhenry.java.ocpjp.chapter13;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedBoxOfficeHits {
    public void printMovieDetails(ResourceBundle resBundle) {
        String moviingName = resBundle.getString("MovieName");
        Long revenue = (Long) (resBundle.getObject("GrossRevenue"));
        Integer year = (Integer) resBundle.getObject("Year");

        System.out.println("Movie " + moviingName + "(" + year + ")" + " grossed " + revenue);
    }

    public static void main(String[] args) throws MalformedURLException {
        LocalizedBoxOfficeHits localizedBoxOfficeHits = new LocalizedBoxOfficeHits();

        // Locale locale = Locale.getDefault();
        // localizedBoxOfficeHits.printMovieDetails(ResourceBundle.getBundle("ResBundle", locale));

        localizedBoxOfficeHits.printMovieDetails(ResourceBundle.getBundle(
                "cn.chenhenry.java.ocpjp.chapter13.ResBundle",
                new Locale("it", "IT", "")
        ));
    }
}
