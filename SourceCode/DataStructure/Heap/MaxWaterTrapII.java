package DataStructure.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a non-negative integer 2D array representing the heights of bars in a matrix.
 * Suppose each bar has length and width of 1.
 * Find the largest amount of water that can be trapped in the matrix.
 * The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height.
 * Each bar has 4 neighboring bars to the left, right, up and down side.
 */
public class MaxWaterTrapII {
    class Pair {
        int x;
        int y;
        int height;
        Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public int waterTrap(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.height == o2.height) {
                    return 0;
                }
                return o1.height < o2.height ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[rows][cols];
        border(matrix, visited, heap, rows, cols);
        int result = 0;
        while (!heap.isEmpty()) {
            Pair cur = heap.poll();
            List<Pair> neis = allNeighbors(cur, matrix);
            for (Pair nei : neis) {
                if (visited[nei.x][nei.y]) {
                    continue;
                }
                visited[nei.x][nei.y] = true;
                result += Math.max(cur.height - nei.height, 0);
                nei.height = Math.max(cur.height, nei.height);
                heap.offer(nei);
            }
        }
        return result;
    }

    private void border(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> heap, int rows, int cols) {
        for (int j = 0; j < cols; j++) {
            heap.offer(new Pair(0, j, matrix[0][j]));
            heap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }
        for (int i = 1; i < rows - 1; i++) {
            heap.offer(new Pair(i, 0, matrix[i][0]));
            heap.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
    }

    private List<Pair> allNeighbors(Pair cur, int[][] matrix) {
        List<Pair> neis = new ArrayList<>();
        if (cur.x + 1 < matrix.length) {
            neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        if (cur.x - 1 >= 0) {
            neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
        }
        if (cur.y + 1 < matrix[0].length) {
            neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
        }
        if (cur.y - 1 >= 0) {
            neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
        }
        return neis;
    }
}
