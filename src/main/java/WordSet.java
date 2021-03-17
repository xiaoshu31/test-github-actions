import java.text.NumberFormat;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSet {
    private TreeMap<String, Integer> map = new TreeMap<String, Integer>();
    private int sum = 0;

    private void add(String word) {
        if (map.containsKey(word)) {
            map.put(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
        sum++;
    }

    public WordSet(String text) {
        Matcher matcher =
                Pattern.compile("[a-z]+(-\n+[a-z]+)*(-[a-z]*)?(-\n+[a-z]+)*")
                        .matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (!word.matches("[a-z]+") && !word.matches("[a-z]+-[a-z]+")) {
                word = word.replaceAll("-\n+", "");
            }
            add(word);
        }
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        StringBuilder result = new StringBuilder();
        for (String word : map.keySet()) {
            result.append(word);
            result.append(' ');
            int i = map.get(word);
            result.append(i);
            result.append(' ');
            result.append(nf.format(1.0 * i / sum));
            result.append('\n');
        }
        return result.toString();
    }
}
