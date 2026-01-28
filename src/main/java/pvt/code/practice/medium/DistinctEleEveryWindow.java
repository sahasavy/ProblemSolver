package pvt.code.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * QB || PROBLEM - 30
 * <p>
 * Given an array and a window size k, return the count of distinct elements in every window.
 * <p>
 * Note: O(n) Time and O(k) Space
 */
public class DistinctEleEveryWindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        List<Integer> windowCount = countDistinct(arr, k);
        System.out.println("Window Count : " + windowCount);
    }

    public static List<Integer> countDistinct(int[] arr, int k) {
        List<Integer> windowCount = new ArrayList<>();
        Map<Integer, Integer> digitCountMap = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            digitCountMap.put(arr[i], digitCountMap.getOrDefault(arr[i], 0) + 1);
        }
        windowCount.add(digitCountMap.size());

        // Slide the window
        for (int j = k; j < arr.length; j++) {
            int outgoing = arr[j - k];
            digitCountMap.put(outgoing, digitCountMap.get(outgoing) - 1);

            if (digitCountMap.get(outgoing) == 0) {
                digitCountMap.remove(outgoing);
            }

            int incoming = arr[j];
            digitCountMap.put(incoming, digitCountMap.getOrDefault(incoming, 0) + 1);

            windowCount.add(digitCountMap.size());
        }

        return windowCount;
    }
}
