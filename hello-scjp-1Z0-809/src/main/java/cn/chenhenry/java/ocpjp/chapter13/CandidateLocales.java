package cn.chenhenry.java.ocpjp.chapter13;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

class TalkativeResourceBundleControl extends ResourceBundle.Control {
    @Override
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        List<Locale> candidateLocales = super.getCandidateLocales(baseName, locale);
        System.out.printf("Candidate locales for base bundle name %s and locale %s %n",
                baseName, locale.getDisplayName());
        return candidateLocales;
    }
}

public class CandidateLocales {
    public static void loadResourceBundle(String resourceBundleName, Locale locale) {
        System.out.println(new Locale("navi", "pandora"));
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                resourceBundleName, locale, new TalkativeResourceBundleControl());
        String rbLocaleName = resourceBundle.getLocale().toString();

        if (rbLocaleName.equals("")) {
            System.out.println("Loaded the default property file with name: " + resourceBundleName);
        } else {
            System.out.println("Loaded the resource bundle for the locale: " + resourceBundleName + "." + rbLocaleName);
        }
    }

    public static void main(String[] args) {
        loadResourceBundle("ResourceBundle", new Locale("it", "IT", "Rome"));
    }
}
