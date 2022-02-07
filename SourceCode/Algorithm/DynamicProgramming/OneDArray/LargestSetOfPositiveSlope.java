package Algorithm.DynamicProgramming.OneDArray;

import java.util.*;

/**
 * Given an array of 2D coordinates of points (all the coordinates are integers),
 * find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope.
 * Return the size of such a maximal set.
 */
public class LargestSetOfPositiveSlope {
    class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int largest(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x == p2.x) {
                    return p1.y < p2.y ? -1 : 1;
                }
                return p1.x < p2.x ? -1 : 1;
            }
        });
        int result = 0;
        int[] longest = new int[points.length];
        for (int i = 0; i < longest.length; i++) {
            longest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (positive(points[j], points[i])) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                }
            }
            result = Math.max(result, longest[i]);
        }
        return result == 1 ? 0 : result;
    }

    private boolean positive(Point p1, Point p2) {
        return (p2.x - p1.x > 0) && (p2.y - p1.y > 0);
    }
}
