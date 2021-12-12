package DataStructure.Array.Sorting.SortingProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 */
public class MeetingRoomI {
    public boolean meeting(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        int[] prev = null;
        boolean result = true;
        for (int[] interval : intervals) {
            if (prev == null) {
                prev = interval;
            } else {
                int outTime = prev[1];
                int curTime = interval[0];
                if (outTime <= curTime) {
                    prev = interval;
                } else {
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }
}

/**
 * time complexity: O(nlogn)
 * space complexity: O(1)
 */