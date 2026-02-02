package pvt.code.practice.practical.sortingalgos;

import java.util.Arrays;

/**
 * Sort an array using the Selection Sort algorithm
 *
 * <p>
 * Selection Sort: This method repeatedly finds the minimum element from the unsorted portion of the array and
 * places it at the beginning of the sorted portion. Its performance is consistent regardless of the initial
 * data order (O(n²)).
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/">geeksforgeeks</a>
 * <p>
 * Note: O(N²) Time and O(1) Space
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 14, 5, 42};
        System.out.println("Original array: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Sorted array (using Selection Sort): " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move the minimum element to the beginning of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the remaining unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted subarray
            // using a temporary variable
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
