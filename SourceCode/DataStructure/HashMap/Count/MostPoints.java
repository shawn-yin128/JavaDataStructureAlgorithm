package DataStructure.HashMap.Count;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of 2D coordinates of points (all the coordinates are integers),
 * find the largest number of points that can be crossed by a single line in 2D space.
 */
public class MostPoints {
    public class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxPoints(Point[] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Point seed = points[i];
            int same = 1; // situation 1: count how many same point
            int sameX = 0; // situation 2: count how many point with same x that slop is infinite
            int most = 0; // situation 3: general case, same slope
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point cur = points[j];
                if (seed.x == cur.x && seed.y == cur.y) { // situation 1
                    same++;
                } else if (seed.x == cur.x) { // situation 2
                    sameX++;
                } else { //situation 3
                    double slope = ((cur.y - seed.y) * 1.0) / (cur.x - seed.x);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                    most = Math.max(most, map.get(slope));
                }
            }
            most = Math.max(sameX, most) + same; // situation 2 and situation 3 cannot happen together
            result = Math.max(most, result);
        }
        return result;
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(n)
 */