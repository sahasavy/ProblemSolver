package pvt.code.practice.practical.sortingalgos;

import java.util.Arrays;

/**
 * Sort an array using the Quick Sort algorithm
 *
 * <p>
 * Quick Sort: Another "divide and conquer" algorithm that picks a "pivot" element and partitions the other
 * elements around it (smaller elements to the left, larger to the right). It is generally the fastest in
 * practice for general purposes.
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/">geeksforgeeks</a>
 * <p>
 * Note: O(n²) Time and O(n) Space
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 2};
        int n = arr.length;

        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array (using Quick Sort): " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * This function takes the last element as a pivot, places the pivot element at its correct position in a
     * sorted array, and places all smaller elements to the left of the pivot and all greater elements to the
     * right of the pivot.
     *
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
