import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution {
    static int n;
    static int[][] map;
    static int[][] dist;

    // 우선순위 큐에 저장할 노드 정보 (행, 열, 현재까지의 누적 복구 비용)
    static class Node implements Comparable<Node> {
        int r, c, cost;

        Node (int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        // 복구 비용이 작은 순서대로 정렬
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dist = new int[n][n]; // 시작점에서 각 위치까지의 최소 복구 비용

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            int answer = dijkstra();

            System.out.println("#" + test_case + " " + answer);
        }
    }

    /*
    * <다익스트라 (Dijkstra) 알고리즘>
    * 가중치가 있는 그래프에서 시작점부터 모든 정점까지의 최소 비용을 구하는 알고리즘
    *
    * 각 칸 = vertex
    * 상하좌우 이동 = edge
    *
    * 비용이 가장 작은 경로를 찾아야 하므로 BFS가 아닌 다익스트라 사용
    * 우선순위 큐를 이용해 현재까지의 복구 비용이 가장 작은 위치부터 탐색
     */
    static int dijkstra() {
        // 상, 하, 좌, 우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 현재까지의 복구 비용이 가장 작은 노드부터 탐색
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            // 현재 가장 복구 비용이 작은 위치 선택
            Node cur = pq.poll();

            // 현재 경로보다 더 짧은 경로로 이미 방문한 적이 있으면 무시
            if (cur.cost > dist[cur.r][cur.c]) continue;

            if (cur.r == n - 1 && cur.c == n - 1) return cur.cost;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int newCost = cur.cost + map[nr][nc];

                // 더 적은 비용으로 이동 가능 시 최소 비용 갱신
                if (dist[nr][nc] > newCost) {
                    dist[nr][nc] = newCost;
                    pq.offer(new Node(nr, nc, newCost));
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}