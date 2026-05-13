package crawler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAnalyzer {

    public static Map<String, Integer> analyze(String text, List<String> keywords) {
        Map<String, Integer> counts = new HashMap<>();
        
        // Clean the text: lowercase it and split by non-word characters
        String[] words = text.toLowerCase().split("\\W+");

        for (String keyword : keywords) {
            int count = 0;
            String lowerKey = keyword.toLowerCase();
            
            for (String word : words) {
                if (word.equals(lowerKey)) {
                    count++;
                }
            }
            counts.put(keyword, count);
        }
        return counts;
    }
}