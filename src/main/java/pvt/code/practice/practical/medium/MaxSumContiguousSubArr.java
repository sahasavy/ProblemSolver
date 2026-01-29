package pvt.code.practice.practical.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * QB || PROBLEM - 3 (Kadane's Algorithm)
 * <p>
 * Given an integer array arr[], find the subarray (containing at least one element) which has the maximum
 * possible sum, and return that sum.
 * <p>
 * Note: A subarray is a continuous part of an array.
 */
public class MaxSumContiguousSubArr {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};           //11
        int[] arr2 = {-2, -4};                          //-2
        int[] arr3 = {5, 4, 1, 7, 8};                   //25
        int[] arr4 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};   //6
        int[] arr5 = {5};                               //5
        int[] arr6 = {};                                //0
        int[] arr7 = {-1, -2, -3};                      //-1
        int[] arr8 = {Integer.MAX_VALUE, -1};           //Integer.MAX_VALUE || 2147483647

        List<int[]> arrList = new ArrayList<>();
        arrList.add(arr1);
        arrList.add(arr2);
        arrList.add(arr3);
        arrList.add(arr4);
        arrList.add(arr5);
        arrList.add(arr6);
        arrList.add(arr7);
        arrList.add(arr8);

        for (int[] arr : arrList) {
            int sum = maxSubarraySum(arr);
            System.out.println("Maximum Subarray Sum : " + sum);
        }
    }

    //  All use-case works
    private static int maxSubarraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        //arr = {2, 3, -8, 7, -1, 2, 3};
        int currentSum = arr[0];//2
        int maxSum = arr[0];//2

        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous subarray or start new from current element
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

//    All use-case works
//    private static int maxSubarraySum(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return 0;
//        }
//
//        //arr = {2, 3, -8, 7, -1, 2, 3};
//        int currentSum = arr[0];//2
//        int maxSum = arr[0];//2
//
//        for (int i = 1; i < arr.length; i++) {
//            int extEleSum = currentSum + arr[i];//5
//            if (extEleSum > arr[i]) {
//                currentSum = extEleSum; // Extend the previous subarray
//            } else {
//                currentSum = arr[i]; // Start new from current element
//            }
//
//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//            }
//        }
//
//        return maxSum;
//    }
}
