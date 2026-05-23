import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            char[][] stone = new char[n][n];

            for (int i = 0; i < n; i++) {
                str[i] = br.readLine();
                for (int j = 0; j < n; j++)
                    stone[i][j] = str[i].charAt(j);
            }

            String res = (isContinuous(stone) ? "YES" : "NO");
            System.out.println("#" + test_case + " " + res);
        }
    }

    static boolean isContinuous(char[][] arr) {
        int len = arr.length;

        /*
        * 탐색 방향 (dr, dc)
        * (0, 1) 오른쪽
        * (1, 0) 왼쪽
        * (1, 1) 오른쪽 아래
        * (1, -1) 왼쪽 아래
         */
        int[] dr = {0, 1, 1, 1};
        int[] dc = {1, 0, 1, -1};

        // 모든 좌표를 시작점으로 하여 탐색
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (arr[r][c] != 'o') continue;

                // 4방향 탐색
                for (int d = 0; d < 4; d++) {
                    int count = 1; // 현재 칸에 돌이 있음

                    // 현재 위치에서 같은 방향으로 4칸 확인
                    for (int k = 1; k < 5; k++) {
                        // 방향(d)으로 k칸 이동한 좌표 (nr, nc)
                        int nr = r + dr[d] * k;
                        int nc = c + dc[d] * k;
                        
                        if (nr < 0 || nr >= len || nc < 0 || nc >= len) break; // 배열 범위 초과
                        if (arr[nr][nc] != 'o') break; // 돌이 없음

                        count++; // 연속된 돌 개수
                    }

                    if (count == 5) return true;
                }
            }
        }

        return false;
    }
}