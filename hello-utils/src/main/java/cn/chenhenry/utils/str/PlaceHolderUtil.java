package cn.chenhenry.utils.str;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author henry
 */
public class PlaceHolderUtil {

    private static final Pattern pattern = Pattern.compile("\\$\\{.*?\\}");
    private static Matcher matcher;


    public static <T> String replaceWithMap(String template, Map<String, String> valueMap) {
        String result = template;

        matcher = pattern.matcher(template);

        while (matcher.find()) {
            String key = matcher.group();
            String holderName = key.substring(2, key.length() - 1).trim();

            String value = valueMap.get(holderName);
            if (null != value) {
                result = result.replace(key, value);
            }
        }

        return result;
    }

}
