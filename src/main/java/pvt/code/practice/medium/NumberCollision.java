package pvt.code.practice.medium;

import java.util.*;

/*
Scenario 1 : Inputs:
int[] arr = [10, 5, -7]

Scenario 1 : Output:
[10]

Scenario 2 : Inputs:
int[] arr = [-8, 2, 10]

Scenario 2 : Output:
[-8, 2, 10]

Reasoning:
positive numbers move right ride
negative numbers move left side
So, for the scenario 1, int[] arr = [10, 5, -7]
10 is a positive number, and thus it will move to the right side.
5 is a positive number, and thus it will move to the right side.
-7 is a negative number, and thus it will move to the left side.
NOW, when -7 moves to the left side and 5 moves to the right side, then its a collision. Due to this collision, only
one number will survive. This is decided based on the below logic:
--> -7 is a more powerful number in the negative series compared to the +5 in the positive series. So -7 wins the collision.
Thus, the current updated array becomes:
arr = [10, -7]

Then again there is a collision happening between 10 and -7.
NOW, 10 is a more powerful number in the positive series compared to the -7 in the negative series. So 10 wins the collision.
Thus, the current updated array becomes:
arr = [10]

There are no more chances of collision. This should be the output.
 */
public class NumberCollision {

    public static void main(String[] args) {
        // Test scenarios
        int[] arr1 = {10, 5, -7};
        int[] arr2 = {-8, 2, 10};
        int[] arr3 = {-10, 5, -8, 3, 7, -4, 6, -9, 2};

        // Resolve collisions
        int[] result1 = resolveCollisions(arr1);
        int[] result2 = resolveCollisions(arr2);
        int[] result3 = resolveCollisions(arr3);

        // Print results
        System.out.println("Scenario 1: " + Arrays.toString(result1)); // Output: [10]
        System.out.println("Scenario 2: " + Arrays.toString(result2)); // Output: [-8, 2, 10]
        System.out.println("Scenario 3: " + Arrays.toString(result3)); // Output: [-10, -8, -9, 2]
    }

    public static int[] resolveCollisions(int[] arr) {
        // Convert the array to a list for easier manipulation
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        boolean collided;
        do {
            collided = false;
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                if (num < 0 && i > 0 && list.get(i - 1) > 0) { // Negative number collides with positive number
                    collided = true;
                    if (Math.abs(num) > list.get(i - 1)) {
                        list.remove(i - 1); // Positive number eliminated
                    } else {
                        list.remove(i); // Negative number eliminated
                    }
                    break;
                }
            }
        } while (collided);

        // Convert the list back to an array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
