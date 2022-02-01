package Algorithm.GraphSearch.BreadthFirstSearch;

import java.util.*;

/**
 * Given a gym with k pieces of equipment and some obstacles.
 * We bought a chair and wanted to put this chair into the gym such that
 * the sum of the shortest path cost from the chair to the k pieces of equipment is minimal.
 * The gym is represented by a char matrix,
 * ‘E’ denotes a cell with equipment,
 * ‘O’ denotes a cell with an obstacle,
 * 'C' denotes a cell without any equipment or obstacle.
 * You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle.
 * The cost of moving from one cell to its neighbor is 1.
 * You can not put the chair on a cell with equipment or obstacle.
 */
public class PlaceChairI {
    private static final char EQUIP = 'E';
    private static final char OB = 'O';

    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        Queue<Pair> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new Pair(i, j));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                Pair cur = queue.poll();
                List<Pair> neis = getNeis(cur, gym);
                for (Pair nei : neis) {
                    if (!visited[nei.i][nei.j]) {
                        visited[nei.i][nei.j] = true;
                        cost[nei.i][nei.j] += pathCost;
                        queue.offer(nei);
                    }
                }
            }
            pathCost++;
        }
        for (int l = 0; l < gym.length; l++) {
            for (int m = 0; m < gym[0].length; m++) {
                if (!visited[l][m] && EQUIP == gym[l][m]) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair> getNeis(Pair cur, char[][] gym) {
        int x = cur.i;
        int y = cur.j;
        int M = gym.length;
        int N = gym[0].length;
        List<Pair> neis = new ArrayList<>();
        if (x + 1 < M && OB != gym[x + 1][y]) {
            neis.add(new Pair(x + 1, y));
        }
        if (y + 1 < N && OB != gym[x][y + 1]) {
            neis.add(new Pair(x, y + 1));
        }
        if (x - 1 >= 0 && OB != gym[x - 1][y]) {
            neis.add(new Pair(x - 1, y));
        }
        if (y - 1 >= 0 && OB != gym[x][y - 1]) {
            neis.add(new Pair(x, y - 1));
        }
        return neis;
    }

    public List<Integer> putChair(char[][] gym) {
        // Write your solution here
        int M = gym.length;
        int N = gym[0].length;
        int[][] cost = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (EQUIP == gym[i][j]) {
                    if (!addCost(cost, gym, i, j)) {
                        return Arrays.asList(-1, -1);
                    }
                }
            }
        }
        List<Integer> result = null;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (EQUIP != gym[i][j] && OB != gym[i][j]) {
                    if (result == null) {
                        result = Arrays.asList(i, j);
                    } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
                        result.set(0, i);
                        result.set(1, j);
                    }
                }
            }
        }
        return result == null ? Arrays.asList(-1, -1) : result;
    }
}
