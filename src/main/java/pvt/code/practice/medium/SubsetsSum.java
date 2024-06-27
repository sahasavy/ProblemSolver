package pvt.code.practice.medium;

import java.util.ArrayList;
import java.util.List;

/*
Input:
{11,2,1,12,13,3,4,9}

Sum should be exactly 12.

Output:
{11,1}
{12}
{3,9}
{2,1,9}

 */
public class SubsetsSum {
    public static void main(String[] args) {
        int[] inputArray = {11, 2, 1, 12, 13, 3, 4, 9};
        int targetSum = 12;

        // Find and print all subsets that sum up to targetSum
        List<List<Integer>> result = findSubsetsThatSumToTarget(inputArray, targetSum);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    private static List<List<Integer>> findSubsetsThatSumToTarget(int[] inputArray, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(inputArray, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsets(int[] inputArray, int targetSum, int startIndex, List<Integer> currentSubset,
                                    List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = startIndex; i < inputArray.length; i++) {
            if (inputArray[i] <= targetSum) {
                currentSubset.add(inputArray[i]);
                findSubsets(inputArray, targetSum - inputArray[i], i + 1, currentSubset, result);
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }
}
