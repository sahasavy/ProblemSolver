package pvt.code.practice.practical.medium;

import java.util.Arrays;

/*
Inputs:
int[] nums = {0,1,-5,3,0,2,0,1}

Output:
{1,-5,3,2,1,0,0,0}

Reasoning:
all non-zero elements should be at the beginning, and zeros at the end
 */
public class Medium1 {
    public static void main(String[] args) {
        Medium1 cus = new Medium1();

        int[] nums = new int[]{0, 1, -5, 3, 0, 2, 0, 1};
        int[] newNum = cus.solve(nums);

        System.out.println(Arrays.toString(newNum));
    }

    private int[] solve(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
