import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int t = Integer.parseInt(br.readLine());

            arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int start = 0;

            for (int i = 0; i < 100; i++) {
                if (arr[0][i] == 1) {
                    visited = new boolean[100][100];

                    if (move(0, i)) {
                        start = i;
                        break;
                    }
                }
            }

            System.out.println("#" + test_case + " " + start);
        }
    }

    static boolean move(int r, int c) {
        // 오른쪽, 왼쪽, 아래
        int[] dr = {0, 0, 1};
        int[] dc = {1, -1, 0};

        if (r == 99)
            return arr[r][c] == 2;

        visited[r][c] = true;

        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100) continue;
            if (visited[nr][nc]) continue;
            if (arr[nr][nc] == 0) continue;

            return move(nr, nc);
        }

        return false;
    }
}