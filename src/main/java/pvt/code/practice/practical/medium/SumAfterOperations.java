package pvt.code.practice.practical.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Inputs:
List<Integer> nums = {10, 7, 20}
k = 4 (iterations)

Output:
5 + 4 + 5 = 14

Reasoning:
{10, 7, 20}
{10, 7, 10} --> Highest = 20, divide by 2 = 10, replace 20 with 10
{5, 7, 10} --> Highest = 10, divide by 2 = 5, replace 10 with 5
{5, 7, 5} --> Highest = 10, divide by 2 = 5, replace 10 with 5
{5, 4, 5} --> Highest = 7, divide by 2 = 3.5, Ceiling value is 4, replace 7 with 4
 */
public class SumAfterOperations {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 7, 20);
        int k = 4;
        System.out.println("Sum after " + k + " operations: " + sumAfterOperations(nums, k));
    }

    public static int sumAfterOperations(List<Integer> nums, int k) {
        // Create a priority queue to store the elements in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Initialize the maxHeap with the input list
        maxHeap.addAll(nums);

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int maxNum = maxHeap.poll(); // Get the maximum number
            int newNum = (int) Math.ceil(maxNum / 2.0); // Calculate the new value
            maxHeap.offer(newNum); // Add the new value back to the maxHeap
        }

        // Calculate the sum of all elements in the maxHeap
        int sum = 0;
        for (int num : maxHeap) {
            sum += num;
        }
        return sum;
    }

//    public static int sumAfterOperations(List<Integer> nums, int k) {
//        // Perform k operations
//        for (int i = 0; i < k; i++) {
//            // Sort the list in descending order
//            Collections.sort(nums, Collections.reverseOrder());
//            // Divide the highest number by 2 and round up
//            int maxNum = nums.get(0);
//            int newNum = (int) Math.ceil(maxNum / 2.0);
//            // Replace the highest number with the new value
//            nums.set(0, newNum);
//        }
//
//        // Calculate the sum of all elements in the modified list
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        return sum;
//    }
}
