package Algorithm.GraphSearch.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Given eight cards with number 0, 1, 2, ..7 on them, the cards are placed in two rows with 4 cards in each row.
 * In each step only card 0 could swap with one of its adjacent(top, right, bottom, left) card.
 */
public class SevenPuzzle {
    class Board {
        public final static int R = 2; // rows
        public final static int C = 4; // cols
        private int[][] board = new int[R][C];

        public Board() {}
        public Board(int[] values) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = values[i*C + j];
                }
            }
        }

        public void swap(int i1, int j1, int i2, int j2) {
            int temp = board[i1][j1];
            board[i1][j1] = board[i2][j2];
            board[i2][j2] = temp;
        }

        public int[] findZero() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 0) {
                        return new int[] {i, j};
                    }
                }
            }
            return null;
        }

        public boolean outOfBound(int i, int j) {
            return i < 0 || i >= R || j < 0 || j >= C;
        }

        @Override
        public int hashCode() {
            int code = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    code = code * 10 + board[i][j];
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Board)) {
                return false;
            }
            Board b = (Board)o;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] != b.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Board clone() {
            Board c = new Board();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    c.board[i][j] = board[i][j];
                }
            }
            return c;
        }
    }

    final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int sevenPuzzle(int[] values) {
        Queue<Board> queue = new ArrayDeque<>();
        Map<Board, Integer> boardStep = new HashMap<>(); // store how many steps needed from beginning status
        Board start = new Board(new int[] {0, 1, 2, 3, 4, 5, 6});
        queue.offer(start);
        boardStep.put(start, 0);

        while (!queue.isEmpty()) {
            Board board = queue.poll();
            int step = boardStep.get(board);
            int[] zero = board.findZero();
            int zeroI = zero[0];
            int zeroJ = zero[1];
            for (int[] dir : DIRS) {
                int i = zeroI + dir[0];
                int j = zeroJ + dir[1];
                if (!board.outOfBound(i, j)) {
                    board.swap(zeroI, zeroJ, i, j);
                    if (!boardStep.containsKey(board)) {
                        Board newBoard = board.clone();
                        queue.offer(newBoard);
                        boardStep.put(newBoard, step + 1);
                    }
                    board.swap(zeroI, zeroJ, i, j);
                }
            }
        }
        return boardStep.getOrDefault(new Board(values), -1);
    }
}
