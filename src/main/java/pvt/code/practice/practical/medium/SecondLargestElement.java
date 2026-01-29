package pvt.code.practice.practical.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * QB || PROBLEM - 1
 * <p>
 * Given an integer array `int[] arr`, return the second-largest DISTINCT element.
 * If it does not exist, return `-1`.
 */
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 20, 8};                //10
        int[] arr2 = {10, 5, 13, 20, 12, 8};        //13
        int[] arr3 = {5, 5, 5};                     //-1
        int[] arr4 = {-1, -5, -3};                  //-3
        int[] arr5 = {10, -5, 20, 5, -15, 25, 0};   //20
        int[] arr6 = {};                            //-1
        int[] arr7 = {1};                           //-1
        int[] arr8 = {2, 1, 2};                     //1
        int[] arr9 = {Integer.MIN_VALUE, -1, -1};   //Integer.MIN_VALUE || -2147483648

        List<int[]> arrList = new ArrayList<>();
        arrList.add(arr1);
        arrList.add(arr2);
        arrList.add(arr3);
        arrList.add(arr4);
        arrList.add(arr5);
        arrList.add(arr6);
        arrList.add(arr7);
        arrList.add(arr8);
        arrList.add(arr9);

        for (int[] arr : arrList) {
            int second = findSecondLargestElement(arr);
//            int second = findKthLargest(arr, 2);
            System.out.println("Second Largest Element : " + second);
        }
    }

    //    Cannot solve the last use-case
    public static int findSecondLargestElement(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num != max) {
                second = num;
            }
        }

        return second == Integer.MIN_VALUE ? -1 : second;
    }

//    SOLVES all the edge-cases
//    public static int findSecondLargestElement(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return -1;
//        }
//
//        Integer max = null;
//        Integer second = null;
//
//        for (int num : arr) {
//            if (max == null || num > max) {
//                if (max != null) {
//                    second = max;
//                }
//                max = num;
//            } else if (num != max && (second == null || num > second)) {
//                second = num;
//            }
//        }
//        return second == null ? -1 : second;
//    }

//    SOLVES all the edge-cases
//    public static Integer findKthLargest(int[] arr, int k) {
//        if (arr == null || arr.length == 0 || k <= 0) {
//            return -1;
//        }
//
//        // 1. Remove duplicates and convert to a list
//        List<Integer> distinctElements = Arrays.stream(arr)
//                .boxed() // Convert int to Integer
//                .distinct() // Remove duplicates
//                .collect(Collectors.toList());
//
//        // Check if k is greater than the number of distinct elements
//        if (k > distinctElements.size()) {
//            return -1;
//        }
//
//        // 2. Sort the list in descending order
//        distinctElements.sort(Collections.reverseOrder());
//
//        // 3. The k-th largest element is at index k-1
//        return distinctElements.get(k - 1);
//    }

//    Cannot solve duplicates and MIN_VALUE use-cases
//    public static int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
//            return -1;
//        }
//
//        // A min-heap (PriorityQueue) to store the 'k' largest elements found so far.
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//
//        for (int num : nums) {
//            heap.add(num);
//            // If the heap size exceeds k, remove the smallest element (at the top)
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//
//        // The top of the heap is the k-th largest element.
//        return heap.peek();
//    }
}
