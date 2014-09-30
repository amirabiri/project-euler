package euler.solutions;

import euler.common.BaseSolution;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;

public class _17 extends BaseSolution {

    private static final String[] NUMBER_WORDS_MAP = {null,
            "one","two","three","four","five","six","seven","eight","nine","ten",
            "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen" };

    private static final String[] NUMBER_10S_WORDS_MAP = {null, null,
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    @Override
    public long solve() {
        int sum = 0;
        for (int number = 1; number <= 1000; number++) {
            for (String word : numberWords(number)) {
                sum += word.length();
            }
        }
        return sum;
    }

    private static List<String> numberWords(int number) {
        if (number < 20) {
            return asList(NUMBER_WORDS_MAP[number]);
        }

        if (number < 100) {
            List<String> words = newArrayList(NUMBER_10S_WORDS_MAP[number / 10]);
            if (number % 10 != 0) {
                words.add(NUMBER_WORDS_MAP[number % 10]);
            }
            return words;
        }

        if (number < 1000) {
            List<String> words = newArrayList(NUMBER_WORDS_MAP[number / 100], "hundred");
            if (number % 100 != 0) {
                words.add("and");
                words.addAll(numberWords(number % 100));
            }
            return words;
        }

        return asList("one", "thousand");
    }
}
