package pvt.code.practice.practical.medium;

import java.util.Arrays;

/**
 * QB || PROBLEM - 2
 * <p>
 * Rotate the array to the right by `k` steps, modifying it in-place.
 *
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

//        int[] arr = {1,2};
//        int k = 3;

//        int[] arr = {1};
//        int k = 100;

//        int[] arr = {1, 2, 3};
//        int k = 0;

//        int[] arr = {};
//        int k = 5;

        System.out.print("Original Array " + Arrays.toString(arr) + " : ");

        int[] rotatedArr = rotateArray(arr, k);

        System.out.print("Rotated (k = " + k + ") to Array : ");
        for (int num : rotatedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] rotateArray(int[] arr, int k) {
        if (arr == null || arr.length <= 1 || k <= 0) {
            return arr;
        }

        for (int i = 0; i < k; i++) {
            rotateArr(arr);
        }

        return arr;
    }

    public static void rotateArr(int[] arr) {
        // arr = {1, 2, 3, 4, 5};
        // arr = {5, 1, 2, 3, 4};
        // arr = {4, 5, 1, 2, 3};

        int temp = arr[arr.length - 1];//temp=5
        int j = 0;
        while (j < arr.length - 1) {
            arr[arr.length - 1 - j] = arr[arr.length - 1 - j - 1];
            j++;
        }
        arr[0] = temp;
    }
}
