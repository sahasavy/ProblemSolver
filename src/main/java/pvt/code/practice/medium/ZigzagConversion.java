package pvt.code.practice.medium;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Example 1:
Input: s = "PAYPALISHIRING", numRows = 1
Output: "PAYPALISHIRING"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 2
Output: "PYAIHRNAPLSIIG"
Explanation:
P Y A ...
A P L ...

Example 3:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Explanation:
P   A   H   N
A P L S I I G
Y   I   R

Example 4:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 5:
Input: s = "PAYPALISHIRING", numRows = 5
Output: "PHASIYIRPLIGAN"
Explanation:
P       H
A     S I
Y   I   R
P L     I G
A       N
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 2;
        String zigzagString = convert(s, numRows);
        System.out.println("Zigzag Conversion String: " + zigzagString);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder rowString : rows) {
            result.append(rowString);
        }

        return result.toString();
    }

//    public static String convert(String s, int numRows) {
//        String zigzagString = "";
//        int[][] zigzagArr = new int[numRows][s.length()];
//        int strIndex = 0;
//
//        for (int column = 0; column < s.length(); column++) {
//            for (int row = 0; row < numRows; row++) {
//                zigzagArr[row][column] = s.charAt(strIndex);
//                strIndex++;
//            }
//            if (strIndex >= s.length()) {
//                break;
//            }
//        }
//
//        // traverse the zigzagArr and populate the zigzagString.
//
//
//        return zigzagString;
//    }
}
