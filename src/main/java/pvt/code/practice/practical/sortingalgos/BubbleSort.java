package pvt.code.practice.practical.sortingalgos;

import java.util.Arrays;

/**
 * Sort an array using the Bubble Sort algorithm
 *
 * <p>
 * Bubble Sort: The simplest algorithm, it repeatedly swaps adjacent elements if they are in the wrong order. It is
 * inefficient for large datasets.
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/">geeksforgeeks</a>
 * <p>
 * Note: O(N²) Time and O(1) Space
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("Sorted array (using Bubble Sort): " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop: traverses all array elements
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // Inner loop: performs the actual swapping
            // The last i elements are already in place, so we iterate only up to n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped by inner loop,
            // then the array is already sorted, and we can break.
            if (!swapped) {
                break;
            }
        }
    }
}
