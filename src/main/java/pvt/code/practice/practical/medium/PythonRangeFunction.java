package pvt.code.practice.practical.medium;

import java.util.ArrayList;

/*
// range(start, stop, step)
 */
public class PythonRangeFunction {
    public static void main(String[] args) {
        ArrayList<Integer> numList1 = range(5);
        System.out.println(numList1);

        ArrayList<Integer> numList2 = range(3, 5);
        System.out.println(numList2);

        ArrayList<Integer> numList22 = range(5, 3);
        System.out.println(numList22);

        ArrayList<Integer> numList3 = range(3, 20, 2);
        System.out.println(numList3);

        ArrayList<Integer> numList4 = range(20, 3, -2);
        System.out.println(numList4);
    }

    private static ArrayList<Integer> range(int stop) {
        return range(0, stop, 1);
    }

    private static ArrayList<Integer> range(int start, int stop) {
        if(stop < start) {
            return new ArrayList<>();
        }
        return range(start, stop, 1);
    }

    private static ArrayList<Integer> range(int start, int stop, int step) {
        ArrayList<Integer> numlist = new ArrayList<>();

        if ((start < stop) && step > 0) {
            for (int i = start; i < stop; i = i + step) {
                numlist.add(i);
            }
        } else if ((stop < start) && step < 0) {
            for (int i = start; i > stop; i = i + step) {
                numlist.add(i);
            }
        } else {
            return new ArrayList<>();
        }
        return numlist;
    }
}
