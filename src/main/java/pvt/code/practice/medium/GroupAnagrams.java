package pvt.code.practice.medium;

import java.util.*;

/**
 * QB || PROBLEM - 22
 * <p>
 * Given an array of strings, group all strings that are anagrams of each other.
 * <p>
 * Note: O(n * k log k) Time and O(n) Space
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagramGroups = groupAnagrams(strArr);

        //[["eat","tea","ate"],["tan","nat"],["bat"]]
        System.out.println("List of all Anagrams : " + anagramGroups);
    }

    public static List<List<String>> groupAnagrams(String[] strArr) {
        Map<String, List<String>> anagramGroupMap = new HashMap<>();

        for (String str : strArr) {
            char[] sortedCharStr = str.toCharArray();
            Arrays.sort(sortedCharStr);
            String sortedStrKey = new String(sortedCharStr);

            List<String> anagramlist;
            if (anagramGroupMap.containsKey(sortedStrKey)) {
                anagramlist = anagramGroupMap.get(sortedStrKey);
            } else {
                anagramlist = new ArrayList<>();
            }
            anagramlist.add(str);
            anagramGroupMap.put(sortedStrKey, anagramlist);
        }

        return new ArrayList<>(anagramGroupMap.values());
    }
}
