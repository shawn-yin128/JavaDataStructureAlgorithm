package Algorithm.GraphSearch.DepthFirstSearch.GeneratCase;

/**
 * Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell.
 * For each pair of cells on the corridor, there must exist one and only one path between them.
 * (Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.).
 * The wall is denoted by 1 in the matrix and corridor is denoted by 0.
 */
public class RandomMaze {
    public int[][] maze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    public enum Dir {
        NORTH(-1, 0),
        SOUTH(1, 0),
        WEST(0, -1),
        EAST(0, 1);

        int deltaX;
        int deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int moveX(int x, int times) {
            return x + times * deltaX;
        }

        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int) (Math.random() * (dirs.length - i));
            Dir temp = dirs[i];
            dirs[i] = dirs[i + index];
            dirs[i + index] = temp;
        }
    }

    private boolean isValidWall(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }

    private void generate(int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX = dir.moveX(x, 2); // need two steps because only one step may happen situatuions like break the wall between two corriders
            int nextY = dir.moveY(y, 2);
            if (isValidWall(maze, nextX, nextY)) {
                maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
                maze[nextX][nextY] = 0;
                generate(maze, nextX, nextY);
            }
        }
    }
}
