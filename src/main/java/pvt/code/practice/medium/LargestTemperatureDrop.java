package pvt.code.practice.medium;

/*
Given an array of temperature for each day of the week consecutively.
Find the largest drop of temperature between any 2 days.
| Mon | Tues | Wed | Thurs | Fri | Sat | Sun |
|-----+------+-----+-------+-----+-----+-----|
| 76  | 72   | 80  | 78    | 68  | 72  | 82  |

OUTPUT:
80-68==>
12
 */
public class LargestTemperatureDrop {
    public static void main(String[] args) {
        int[] temperatures = {76, 72, 80, 78, 68, 72, 82};
        int largestDrop = findLargestTemperatureDrop(temperatures);
        System.out.println("Largest temperature drop: " + largestDrop);
    }

    public static int findLargestTemperatureDrop(int[] temperatures) {
        int largestDrop = 0;

        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                int drop = temperatures[i] - temperatures[j];
                if (drop > largestDrop) {
                    largestDrop = drop;
                }
            }
        }

        return largestDrop;
    }
}
