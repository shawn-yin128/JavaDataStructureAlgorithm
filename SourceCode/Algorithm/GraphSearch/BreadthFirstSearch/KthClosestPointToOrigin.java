package Algorithm.GraphSearch.BreadthFirstSearch;

import java.util.*;

/**
 * Given three arrays sorted in ascending order.
 * Pull one number from each array to form a coordinate (x,y,z) in a 3D space.
 * Find the coordinates of the points that is k-th closest to (0,0,0).
 */
public class KthClosestPointToOrigin {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long d1 = distance(o1, a, b, c);
                long d2 = distance(o2, a, b, c);
                if (d1 == d2) {
                    return 0;
                }
                return d1 < d2 ? -1 : 1;
            }
        });
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> cur = Arrays.asList(0, 0, 0);
        visited.add(cur);
        heap.offer(cur);
        while (k > 0) {
            cur = heap.poll();
            List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (next.get(0) < a.length && visited.add(next)) {
                heap.offer(next);
            }
            next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (next.get(1) < b.length && visited.add(next)) {
                heap.offer(next);
            }
            next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (next.get(2) < c.length && visited.add(next)) {
                heap.offer(next);
            }
            k--;
        }
        cur.set(0, a[cur.get(0)]);
        cur.set(1, b[cur.get(1)]);
        cur.set(2, c[cur.get(2)]);
        return cur;
    }

    private long distance(List<Integer> point, int[] a, int[] b, int[] c) {
        long dis = 0;
        dis += a[point.get(0)] * a[point.get(0)];
        dis += b[point.get(1)] * b[point.get(1)];
        dis += c[point.get(2)] * c[point.get(2)];
        return dis;
    }
}

/**
 * time complexity: O(klogk)
 * space complexity: O(k)
 */