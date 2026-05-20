import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int n, m;
    static int max;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new boolean[n + 1][n + 1];
            visited = new boolean[n + 1]; // 방문 여부
            max = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = true;
                graph[y][x] = true;
            }

            // 모든 정점을 시작점으로 하여 dfs 탐색
            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                dfs(i, 1); // 시작 정점 포함이므로 len = 1부터 시작
                visited[i] = false;
            }

            System.out.println("#" + test_case + " " + max);
        }
    }

    // DFS + 백트래킹
    static void dfs(int cur, int len) {
        // 최장 경로 갱신
        max = Math.max(max, len);

        // 현재 정점과 연결된 정점 탐색
        for (int next = 1; next <= n; next++) {
            // 연결되어 있는 정점을 방문하지 않았을 때
            if (graph[cur][next] && !visited[next]) {
                visited[next] = true;
                dfs(next, len + 1);
                visited[next] = false;
            }
        }
    }
}