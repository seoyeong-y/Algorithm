import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int n, m;
    static int[][] stone;

    // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            stone = new int[n][n];
            
            stone[n / 2 - 1][n / 2 - 1] = 2;
            stone[n / 2][n / 2] = 2;
            stone[n / 2 - 1][n / 2] = 1;
            stone[n / 2][n / 2 - 1] = 1;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());

                othello(x, y, color);
            }

            int black = 0;
            int white = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (stone[i][j] == 1) black++;
                    else if (stone[i][j] == 2) white++;
                }
            }

            System.out.println("#" + test_case + " " + black + " " + white);
        }
    }

    static void othello(int r, int c, int color) {
        stone[r][c] = color;

        int opponentColor = (color == 1) ? 2 : 1;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            int count = 0;

            // 해당 방향으로 상대 돌이 연속해서 있는지 확인
            while (nr >= 0 && nr < n && nc >= 0 && nc < n
                    && stone[nr][nc] == opponentColor) {
                nr += dr[d];
                nc += dc[d];
                count++;
            }

            // 상대 돌 뒤에 내 돌이 있으면 사이에 있는 상대 돌 뒤집기
            if (count > 0 && nr >= 0 && nr < n && nc >= 0 && nc < n
                    && stone[nr][nc] == color) {

                for (int i = 1; i <= count; i++) {
                    int cr = r + dr[d] * i;
                    int cc = c + dc[d] * i;
                    stone[cr][cc] = color;
                }
            }
        }
    }
}