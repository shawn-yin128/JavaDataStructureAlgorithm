package Algorithm.GraphSearch.BestFirstSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given two sorted arrays A and B, of sizes m and n respectively.
 * Define s = a + b, where a is one element from A and b is one element from B.
 * Find the Kth smallest s out of all possible s'.
 */
public class KthSmallInTwoSortedArrays {
    class Pair {
        int x;
        int y;
        int sum;
        Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public int kSmall(int[] a, int[] b, int k) {
        Pair[][] pair = new Pair[a.length][b.length];
        boolean[][] visited = new boolean[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                pair[i][j] = new Pair(i, j, a[i]+b[j]);
            }
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.sum == o2.sum) {
                    return 0;
                }
                return o1.sum < o2.sum ? -1 : 1;
            }
        });
        heap.offer(pair[0][0]);
        visited[0][0] = true;
        int result = 0;
        for (int K = k; K > 0; K--) {
            Pair cur = heap.poll();
            result = cur.sum;
            if (cur.x + 1 < a.length && !visited[cur.x + 1][cur.y]) {
                visited[cur.x + 1][cur.y] = true;
                heap.offer(pair[cur.x + 1][cur.y]);
            }
            if (cur.y + 1 < b.length && !visited[cur.x][cur.y + 1]) {
                visited[cur.x][cur.y + 1] = true;
                heap.offer(pair[cur.x][cur.y + 1]);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n*m + klog2k)
 * space complexity: O(n*m + 2k)
 */