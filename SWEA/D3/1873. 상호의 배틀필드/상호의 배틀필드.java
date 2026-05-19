import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int h, w;
    static char[][] map; // 게임 맵
    static int tankR, tankC; // 전차 위치
    static char dir; // 전차 방향

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                String line = br.readLine();

                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);

                    // 전차 위치 및 방향
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        tankR = i;
                        tankC = j;
                        dir = map[i][j];
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (int i = 0; i < n; i++) {
                char cmd = commands.charAt(i);

                if (cmd == 'S') shoot();
                else move(cmd);
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < h; i++)
                System.out.println(map[i]);
        }
    }

    // 전차 이동
    static void move(char cmd) {
        int nr = tankR;
        int nc = tankC;

        // 방향 변경 및 위치 계산
        if (cmd == 'U') {
            dir = '^';
            nr--;
        } else if (cmd == 'D') {
            dir = 'v';
            nr++;
        } else if (cmd == 'L') {
            dir = '<';
            nc--;
        } else if (cmd == 'R') {
            dir = '>';
            nc++;
        }

        // 현재 방향 갱신
        map[tankR][tankC] = dir;

        // 맵 밖은 이동 불가
        if (nr < 0 || nr >= h || nc < 0 || nc >= w) return;

        // 평지인 경우 이동
        if (map[nr][nc] == '.') {
            map[tankR][tankC] = '.';

            tankR = nr;
            tankC = nc;

            map[tankR][tankC] = dir; // 이동한 위치에 전차 배치
        }
    }

    // 포탄 발사
    static void shoot() {
        int dr = 0;
        int dc = 0;

        // 현재 방향에 따른 이동 방향 설정
        if (dir == '^') dr = -1;
        else if (dir == 'v') dr = 1;
        else if (dir == '<') dc = -1;
        else if (dir == '>') dc = 1;

        // 포탄 시작 위치
        int nr = tankR + dr;
        int nc = tankC + dc;

        while (nr >= 0 && nr < h && nc >= 0 && nc < w) {
            if (map[nr][nc] == '*') { // 벽돌 벽이면 파괴 후 종료
                map[nr][nc] = '.';
                break;
            }

            if (map[nr][nc] == '#') break; // 강철 벽이면 종료

            nr += dr;
            nc += dc;
        }
    }
}