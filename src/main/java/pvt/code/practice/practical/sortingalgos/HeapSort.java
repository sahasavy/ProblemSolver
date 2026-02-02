package pvt.code.practice.practical.sortingalgos;

import java.util.Arrays;

/**
 * Sort an array using the Heap Sort algorithm
 *
 * <p>
 * Heap Sort: This algorithm sorts elements by first building a binary heap data structure and then repeatedly
 * extracting the maximum element from the heap and placing it at the end of the array.
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/heap-sort-algorithm/">geeksforgeeks</a>
 * <p>
 * Note: O(n log n) Time and O(1) Space
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Sorted array (using Heap Sort): " + Arrays.toString(arr));
    }

    /**
     * Sorts an array using the Heap Sort algorithm.
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) for in-place sorting
     *
     * @param arr The array of integers to be sorted.
     */
    public void sort(int[] arr) {
        int n = arr.length;

        // 1. Build a max heap (rearrange array)
        // Start from the last non-leaf node: index (n/2 - 1)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end (swap the maximum element with the last element)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Helper method to turn a subtree rooted with node i into a max heap.
     * n is the size of the heap.
     */
    void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap arr[i] and arr[largest]
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}
