package pvt.code.practice.practical.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * James is a businessman. He is on a tight schedule this week. The week starts on Monday at 00:00 and ends on Sunday at 24:00. His schedule consists of M meetings he needs to take part in. Each of them will take place in a period of time, beginning and ending on the same day (there are no two ongoing meetings at the same time). James is very tired, thus he needs to find the longest possible time slot to sleep. In other words, he wants to find the longest period of time when there are no ongoing meetings. The sleeping break can begin and end on different days and should begin and end in the same week.
 * <p>
 * You are given a string containing M lines. Each line is a substring representing one meeting in the schedule, in the format "Ddd hh:mm-hh:mm". "Ddd" is a three-letter abbreviation for the day of the week when the meeting takes place: "Mon" (Monday), "Tue", "Wed", "Thu", "Fri", "Sat", "Sun".  "hh:mm-hh:mm" means the beginning time and the ending time of the meeting (from 00:00 to 24:00 inclusive).
 * <p>
 * The given times represent exact moments of time. So, there are exactly five minutes between 13:40 and 13:45.
 * <p>
 * For example, given a string:
 * "Sun 10:00-20:00
 * Fri 05:00-10:00
 * Fri 16:30-23:50
 * Sat 10:00-24:00
 * Sun 01:00-04:00
 * Sat 02:00-06:00
 * Tue 03:30-18:15
 * Tue 19:00-20:00
 * Wed 04:25-15:14
 * Wed 15:14-22:40
 * Thu 00:00-23:59
 * Mon 05:00-13:00
 * Mon 15:00-21:00"
 * The longest time slot when James can sleep is 505 minutes, since James can sleep from Tuesday 20:00 to Wednesday 04:25, which gives 8 hours and 25 minutes = 505 minutes.
 * <p>
 * Also, for a string:
 * "Mon 01:00-23:00
 * Tue 01:00-23:00
 * Wed 01:00-23:00
 * Thu 01:00-23:00
 * Fri 01:00-23:00
 * Sat 01:00-23:00
 * Sun 01:00-21:00"
 * James should sleep on Sunday from 21:00 to 24:00 (180 minutes).
 * <p>
 * Write a function:
 * <br>
 * class Solution {
 * <br>
 * public int solution(String S) {
 * <br>
 * // your code
 * <br>
 * }
 * <br>
 * }
 * <br>
 * that, given a string S representing the schedule, returns the length of the longest time slot when James can sleep (in minutes).
 * <p>
 * Assume that:
 * <br>
 * - M is an integer within the range [1..100];
 * <br>
 * - Each line of the input string is in the format "Ddd hh:mm-hh:mm" and lines are separated with newline characters;
 * <br>
 * - There cannot be two ongoing meetings at any time;
 * <br>
 * - Each meeting lasts at least 1 minute.
 * <br>
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * <p>
 * <p>
 * Example 1:
 * <br>
 * Input String S:
 * "Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00\n"
 * <br>
 * Output Expected:
 * 505
 * <p>
 * <p>
 * Example 2:
 * <br>
 * Input String S:
 * "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00\n"
 * <br>
 * Output Expected:
 * 180
 * <p>
 * NOTE:
 * Please consider the Assumptions very carefully.
 */
public class MeetingScheduler {

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = new MeetingScheduler();
        String str1 = "Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00\n";
        System.out.println("Minutes : " + meetingScheduler.solution(str1));

        String str2 = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00\n";
        System.out.println("Minutes : " + meetingScheduler.solution(str2));
    }

    private int solution(String S) {
        // Step 1: Parse the input string to extract meeting start and end times
        Map<String, List<int[]>> schedule = new HashMap<>();
        for (String line : S.split("\n")) {
            String[] parts = line.split(" ");
            String day = parts[0];
            String[] times = parts[1].split("-");
            int[] startTime = parseTime(times[0]);
            int[] endTime = parseTime(times[1]);

            schedule.computeIfAbsent(day, k -> new ArrayList<>())
                    .add(new int[]{startTime[0] * 60 + startTime[1], endTime[0] * 60 + endTime[1]});
        }

        // Step 2: Create availability data structure
        boolean[] availability = new boolean[7 * 24 * 60]; // 7 days in a week, each day has 24 hours, each hour has 60 minutes

        // Step 3: Mark minutes with meetings as unavailable
        for (List<int[]> meetings : schedule.values()) {
            for (int[] meeting : meetings) {
                int start = meeting[0];
                int end = meeting[1];
                for (int i = start; i < end; i++) {
                    availability[i] = true;
                }
            }
        }

        // Step 4: Find the longest continuous period of available time
        int longestSleep = 0;
        int currentSleep = 0;
        for (boolean available : availability) {
            if (available) {
                currentSleep = 0; // Reset sleep counter
            } else {
                currentSleep++; // Increment sleep counter
                longestSleep = Math.max(longestSleep, currentSleep); // Update longest sleep
            }
        }

        // Step 5: Convert the longest continuous period of available time into minutes
        return longestSleep;
    }

    // Helper function to parse time into hours and minutes
    private int[] parseTime(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return new int[]{hours, minutes};
    }
}
