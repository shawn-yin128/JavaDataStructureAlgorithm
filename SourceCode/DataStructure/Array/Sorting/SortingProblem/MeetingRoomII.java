package DataStructure.Array.Sorting.SortingProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 */
public class MeetingRoomII {
    public int meeting(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return 0;
                }
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        int maxSize = 0;
        for (int[] interval : intervals) {
            if (heap.isEmpty()) {
                heap.add(interval);
                maxSize = Math.max(maxSize, heap.size());
            } else {
                int[] next = heap.peek();
                int curTime = interval[0];
                while (!heap.isEmpty() && next[1] <= curTime) {
                    heap.poll();
                    next = heap.peek();
                }
                heap.add(interval);
                maxSize = Math.max(maxSize, heap.size());
            }
        }
        return maxSize;
    }
}

/**
 * time complexity: O(nlogn)
 * space complexity: O(n)
 */