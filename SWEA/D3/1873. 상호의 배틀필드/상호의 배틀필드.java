import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int h, w;
    static char[][] map;
    static int tankR, tankC;
    static char dir;

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

    static void move(char cmd) {
        int nr = tankR;
        int nc = tankC;

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

        map[tankR][tankC] = dir;

        if (nr < 0 || nr >= h || nc < 0 || nc >= w) return;

        if (map[nr][nc] == '.') {
            map[tankR][tankC] = '.';

            tankR = nr;
            tankC = nc;

            map[tankR][tankC] = dir;
        }
    }

    static void shoot() {
        int dr = 0;
        int dc = 0;

        if (dir == '^') dr = -1;
        else if (dir == 'v') dr = 1;
        else if (dir == '<') dc = -1;
        else if (dir == '>') dc = 1;

        int nr = tankR + dr;
        int nc = tankC + dc;

        while (nr >= 0 && nr < h && nc >= 0 && nc < w) {
            if (map[nr][nc] == '*') {
                map[nr][nc] = '.';
                break;
            }

            if (map[nr][nc] == '#') break;

            nr += dr;
            nc += dc;
        }
    }
}