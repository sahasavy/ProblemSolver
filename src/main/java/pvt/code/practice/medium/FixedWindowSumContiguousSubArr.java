package pvt.code.practice.medium;

/**
 * QB || PROBLEM - 51 (Sliding Window Technique)
 * <p>
 * Given an array arr[] and an integer k, we need to calculate the maximum sum of a subarray having size exactly k.
 * <p>
 * Note: O(n) Time and O(1) Space
 */
public class FixedWindowSumContiguousSubArr {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};         //9
        int k = 3;

//        int[] arr = {5, 2, -1, 0, 3};           //6
//        int k = 3;

//        int[] arr = {10, 20, 30, 40, 50};       //90
//        int k = 2;

        int sum = maxSumSubarray(arr, k);
        System.out.println("Maximum Subarray Sum : " + sum);

    }

    public static int maxSumSubarray(int[] arr, int k) {
        int currentWindowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
            maxSum = currentWindowSum;
        }

        for (int i = k; i < arr.length; i++) {
            currentWindowSum += arr[i] - arr[i - k];
            maxSum = Math.max(currentWindowSum, maxSum);
        }

        return maxSum;
    }
}
