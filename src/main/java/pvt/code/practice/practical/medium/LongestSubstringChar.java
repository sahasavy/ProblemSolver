package pvt.code.practice.practical.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * QB || PROBLEM - 21
 * <p>
 * Return the length of the longest substring without repeating characters.
 * <p>
 * Note: O(n) Time and O(n) Space
 */
public class LongestSubstringChar {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int maxLength = longestSubString(str);
        System.out.println("The Max Length : " + maxLength);
    }

    public static int longestSubString(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);

            if (charIndexMap.containsKey(ch)) {
                left = Math.max(left, charIndexMap.get(ch) + 1);
            }
            charIndexMap.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
