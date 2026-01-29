package pvt.code.practice.practical.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * QB || PROBLEM - 25
 * <p>
 * Two strings are isomorphic if characters in one string can be replaced to get the other string, preserving order.
 * <p>
 * Note: O(n) Time and O(n) Space
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String str1 = "egg";
        String str2 = "add";

        boolean isomorphic = isIsomorphic(str1, str2);
        System.out.println("Is Isomorphic : " + isomorphic);
    }

    public static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (map1.containsKey(ch1) && map1.get(ch1) != ch2) {
                return false;
            }

            if (map2.containsKey(ch2) && map2.get(ch2) != ch1) {
                return false;
            }

            map1.put(ch1, ch2);
            map2.put(ch2, ch1);
        }
        return true;
    }
}
