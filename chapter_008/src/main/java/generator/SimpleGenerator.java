package generator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SimpleGenerator {
    private static final Pattern KEYS = Pattern.compile("\\$\\{([a-zA-Z]+)\\}");

    public static String formatString(String template, Map<String, String> values) {
        Matcher m = KEYS.matcher(template);
        if (m.results().map(k->k.group(1)).distinct().count() != (long) values.size()) {
            throw new RuntimeException("wrong count of keys");
        }
        return m.replaceAll(matchResult -> values.get(matchResult.group(1)));
    }

}


