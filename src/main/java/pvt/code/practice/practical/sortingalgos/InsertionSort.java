package pvt.code.practice.practical.sortingalgos;

import java.util.Arrays;

/**
 * Sort an array using the Insertion Sort algorithm
 *
 * <p>
 * Insertion Sort: Similar to sorting playing cards in hand, it builds the final sorted array one item at a time
 * by inserting each new element into its correct position within the already sorted part. It performs well for
 * small or mostly sorted arrays.
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/">geeksforgeeks</a>
 * <p>
 * Note: O(N²) Time and O(1) Space
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original array: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Sorted array (using Insertion Sort): " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            // Key is the element to be inserted into the sorted subarray
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
