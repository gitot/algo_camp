package com.github.algo.base.solution.hashtable;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SInterview16_02 {

    class WordsFrequency {
        Map<String, Integer> wordCount = new HashMap<>();

        public WordsFrequency(String[] book) {
            if (book == null || book.length == 0) {
                return;
            }
            for (String s : book) {
                if (!wordCount.containsKey(s)) {
                    wordCount.put(s, 1);
                    continue;
                }
                wordCount.put(s, 1 + wordCount.get(s));
            }
        }

        public int get(String word) {
            return wordCount.get(word) == null ? 0 : wordCount.get(word);
        }
    }

}
