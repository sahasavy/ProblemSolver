package pvt.code.practice.practical.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all unique triplets [a, b, c] such that a + b + c = 0.
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Unique triplets that sum to zero: " + triplets);
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]]
    }

    /**
     * Finds all unique triplets in the array that sum up to zero.
     * The approach uses sorting and a two-pointer technique to efficiently find pairs.
     *
     * @param nums The input integer array.
     * @return A list of unique triplets that sum to zero.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to easily handle duplicates and use the two-pointer technique
        Arrays.sort(nums);
        // Sorted nums = {-4, -1, -1, 0, 1, 2};

        List<List<Integer>> result = new ArrayList<>();
        int arrLen = nums.length;

        // Iterate through the array with the 'a' pointer
        for (int i = 0; i < arrLen - 2; i++) {
            // Skip duplicate values for 'a' to avoid duplicate triplets in the result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // 'b' pointer
            int right = arrLen - 1; // 'c' pointer
            int target = -nums[i]; // We are looking for b + c = -a

            while (left < right) {
                int currentSum = nums[left] + nums[right];

                if (currentSum == target) {
                    // Found a triplet: [a, b, c]
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for 'b'
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for 'c'
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward to find the next unique pair
                    left++;
                    right--;
                } else if (currentSum < target) {
                    // Sum is too small, need a larger 'b'
                    left++;
                } else {
                    // Sum is too large, need a smaller 'c'
                    right--;
                }
            }
        }

        return result;
    }
}
