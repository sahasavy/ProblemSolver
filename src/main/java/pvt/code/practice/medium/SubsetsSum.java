package pvt.code.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * WAP to find the Subset Sum with Duplicate elements.
 * <p>
 * For the following inputs: int[] arr = {11, 1, 2, 1, 12, 13, 3, 4, 9, 1, 0};
 * int targetSum = 12;
 * <p>
 * Print all the possible element combinations that add up to the target sum.
 * <p>
 * Output:
 * {12}
 * {11, 1}
 * {9, 3}
 * {9, 2, 1}
 * {9, 1, 1, 1}
 * {4, 3, 2, 1, 1, 1}
 * {12, 0}
 * {11, 1, 0}
 * {9, 3, 0}
 * {9, 2, 1, 0}
 * {9, 1, 1, 1, 0}
 * {4, 3, 2, 1, 1, 1, 0}
 * <p>
 * NOTE: This is a Java backtracking solution
 */
public class SubsetsSum {
    public static void main(String[] args) {
        int[] inputArray = {11, 1, 2, 1, 12, 13, 3, 4, 9, 1, 0};
        int targetSum = 12;

        // Find and print all subsets that sum up to targetSum
        List<List<Integer>> result = findSubsetsThatSumToTarget(inputArray, targetSum);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    private static List<List<Integer>> findSubsetsThatSumToTarget(int[] inputArray, int targetSum) {
        Arrays.sort(inputArray); // {0, 1, 1, 1, 2, 3, 4, 9, 11, 12, 13}
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(inputArray, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsets(int[] inputArray, int remainingSum, int startIndex, List<Integer> currentSubset,
                                    List<List<Integer>> result) {
        if (remainingSum == 0) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        // inputArray = {0, 1, 1, 1, 2, 3, 4, 9, 11, 12, 13}
        for (int i = startIndex; i < inputArray.length; i++) {
            // skip duplicates
            if (i > startIndex && inputArray[i] == inputArray[i - 1]) {
                continue;
            }

            if (inputArray[i] > remainingSum) {
                break; // pruning
            }

            currentSubset.add(inputArray[i]);
            findSubsets(inputArray, remainingSum - inputArray[i], i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
