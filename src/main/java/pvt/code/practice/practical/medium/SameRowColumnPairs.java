package pvt.code.practice.practical.medium;

import java.util.*;

/*
Inputs:
int[][] arr2D =
3 2 1
4 7 8
2 7 7

Output:
1

Reasoning:
pairs of same rows and columns = 1
row number --> [2, 7, 7]
column --> [2, 7, 7]
 */
public class SameRowColumnPairs {

    public static void main(String[] args) {
        int[][] arr2D = {
                {3, 2, 1},
                {4, 7, 8},
                {2, 7, 7}
        };

        int result = countSameRowColumnPairs(arr2D);
        System.out.println("Output: " + result); // Output: 1
    }

    public static int countSameRowColumnPairs(int[][] arr2D) {
        int size = arr2D.length;
        Set<String> uniqueRows = new HashSet<>();
        Set<String> uniqueColumns = new HashSet<>();

        // Fill uniqueRows and uniqueColumns
        for (int i = 0; i < size; i++) {
            StringBuilder rowString = new StringBuilder();
            StringBuilder columnString = new StringBuilder();
            for (int j = 0; j < size; j++) {
                rowString.append(arr2D[i][j]).append(" ");
                columnString.append(arr2D[j][i]).append(" ");
            }
            uniqueRows.add(rowString.toString().trim());
            uniqueColumns.add(columnString.toString().trim());
        }

        // Finding common elements between uniqueRows and uniqueColumns
//        Set<String> commonStrings = new HashSet<>(uniqueRows);
//        commonStrings.retainAll(uniqueColumns);
        Set<String> commonStrings = new HashSet<>();
        for (String row : uniqueRows) {
            if (uniqueColumns.contains(row)) {
                commonStrings.add(row);
            }
        }

        return commonStrings.size();
    }
}
