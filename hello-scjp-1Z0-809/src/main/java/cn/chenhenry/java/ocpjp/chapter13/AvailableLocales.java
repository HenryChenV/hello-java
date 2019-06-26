package cn.chenhenry.java.ocpjp.chapter13;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

public class AvailableLocales {
    public static void main(String[] args) {
        System.out.println("The default locale is: " + Locale.getDefault());

        Locale[] locales = Locale.getAvailableLocales();
        System.out.printf("No. of other available locales is: %d, and the are: %n", locales.length);
        Arrays.stream(locales).forEach(
                locale -> System.out.printf("Locale code: %s and it stands for %s %n", locale, locale.getDisplayName())
        );
    }
}


class AvailableLocalesEnglish {
    public static void main(String[] args) {
        String languageCode = "en";
        Arrays.stream(Locale.getAvailableLocales())
                .filter(locale -> locale.getLanguage().equals(languageCode))
                .forEach(locale -> System.out.printf(
                        "Locale code: %s and it stands for %s %n", locale, locale.getDisplayName()));
    }
}
