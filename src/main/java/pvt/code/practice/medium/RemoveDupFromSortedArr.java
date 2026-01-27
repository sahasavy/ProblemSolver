package pvt.code.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * QB || PROBLEM - 4
 * <p>
 * Given a sorted array arr[] of size n, the goal is to rearrange the array so that all distinct elements appear
 * at the beginning in sorted order. Additionally, return the length of this distinct sorted subarray.
 * <p>
 * Note: The elements after the distinct ones can be in any order and hold any value, as they don't affect the result.
 */
public class RemoveDupFromSortedArr {

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 2, 2, 2};                   //1
        int[] arr2 = {1, 2, 3};                         //3
        int[] arr3 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};    //5
        int[] arr4 = {1, 1, 1, 1, 2, 5, 7, 9, 11};      //6
        int[] arr5 = {5};                               //1
        int[] arr6 = {};                                //0

        List<int[]> arrList = new ArrayList<>();
        arrList.add(arr1);
        arrList.add(arr2);
        arrList.add(arr3);
        arrList.add(arr4);
        arrList.add(arr5);
        arrList.add(arr6);

        for (int[] arr : arrList) {
            int newSize = removeDuplicates(arr);
            System.out.println("Length of new array : " + newSize);
        }
    }

    private static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return 1;
        }

        // Start from the second element
        int idx = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[idx++] = arr[i];
            }
        }

//        System.out.println("Current array condition : " + Arrays.toString(arr));
        return idx;
    }

//    private static int removeDuplicates(int[] arr) {
//        return Arrays.stream(arr)
//                .boxed() // Convert int to Integer
//                .distinct() // Remove duplicates
//                .toList()
//                .size();
//    }
}
