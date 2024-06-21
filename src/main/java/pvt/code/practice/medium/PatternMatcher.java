package pvt.code.practice.medium;

import java.util.HashMap;
import java.util.Map;

/*
pattern --> "a b b a"
String --> "tea coffee coffee tea" --> return true
String --> "tea coffee coffee tea tea coffee coffee tea" --> return true
String --> "tea1 coffee coffee tea" --> return false
String --> "tea tea1 coffee tea coffee" --> return false
 */
public class PatternMatcher {

    public static void main(String[] args) {
        // Test cases
        System.out.println(matchesPattern("a b b a", "tea coffee coffee tea")); // true
        System.out.println(matchesPattern("a b b a", "tea coffee coffee tea tea coffee coffee tea")); // true
        System.out.println(matchesPattern("a b b a", "tea coffee coffee tea tea coffee coffee tea text")); // false
        System.out.println(matchesPattern("a b b a", "tea1 coffee coffee tea tea coffee coffee tea")); // false
        System.out.println(matchesPattern("a b b a", "tea coffee coffee tea tea1 coffee coffee tea")); // false
        System.out.println(matchesPattern("a b b a", "tea1 coffee coffee tea")); // false
        System.out.println(matchesPattern("a b b a", "tea tata coffee tea coffee")); // false
        System.out.println(matchesPattern("a a b c", "table table top toy")); // true
        System.out.println(matchesPattern("a a b c", "table hi table top toy")); // false
    }

    public static boolean matchesPattern(String pattern, String actualStr) {
        String[] patternTokens = pattern.split(" ");
        String[] actualTokens = actualStr.split(" ");

        // Check if the length of actual tokens is a multiple of the length of pattern tokens
        if (actualTokens.length % patternTokens.length != 0) {
            return false;
        }

        int numChunks = actualTokens.length / patternTokens.length;

        // Iterate through each chunk
        for (int chunk = 0; chunk < numChunks; chunk++) {
            Map<String, String> patternToWordMap = new HashMap<>();
            Map<String, String> wordToPatternMap = new HashMap<>();

            for (int i = 0; i < patternTokens.length; i++) {
                String patternToken = patternTokens[i];
                String actualToken = actualTokens[chunk * patternTokens.length + i];

                // Check if the current pattern token has been mapped to a different word
                if (patternToWordMap.containsKey(patternToken)) {
                    if (!patternToWordMap.get(patternToken).equals(actualToken)) {
                        return false;
                    }
                } else {
                    patternToWordMap.put(patternToken, actualToken);
                }

                // Check if the current actual token has been mapped to a different pattern token
                if (wordToPatternMap.containsKey(actualToken)) {
                    if (!wordToPatternMap.get(actualToken).equals(patternToken)) {
                        return false;
                    }
                } else {
                    wordToPatternMap.put(actualToken, patternToken);
                }
            }
        }

        return true;
    }
}
