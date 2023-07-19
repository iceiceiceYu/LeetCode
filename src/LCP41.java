import java.util.ArrayDeque;
import java.util.Queue;

public class LCP41 {
    static int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int flipChess(String[] chessboard) {
        int res = 0;
        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[0].length(); ++j) {
                if (chessboard[i].charAt(j) == '.') {
                    res = Math.max(res, bfs(chessboard, i, j));
                }
            }
        }
        return res;
    }

    public int bfs(String[] chessboard, int px, int py) {
        char[][] board = new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[0].length(); ++j) {
                board[i][j] = chessboard[i].charAt(j);
            }
        }
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{px, py});
        board[px][py] = 'X';
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 8; ++i) {
                if (judge(board, t[0], t[1], dirs[i][0], dirs[i][1])) {
                    int x = t[0] + dirs[i][0], y = t[1] + dirs[i][1];
                    while (board[x][y] != 'X') {
                        queue.offer(new int[]{x, y});
                        board[x][y] = 'X';
                        x += dirs[i][0];
                        y += dirs[i][1];
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }

    public boolean judge(char[][] board, int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (0 <= x && x < board.length && 0 <= y && y < board[0].length) {
            if (board[x][y] == 'X') {
                return true;
            } else if (board[x][y] == '.') {
                return false;
            }
            x += dx;
            y += dy;
        }
        return false;
    }
}
