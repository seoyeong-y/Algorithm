import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치 기준 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[e];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(a, b, c);
            }

            // 가중치 기준 정렬
            Arrays.sort(edges);

            parent = new int[v + 1];
            
            for (int i = 1; i <= v; i++) {
                parent[i] = i;
            }

            long res = 0;
            int cnt = 0; // 선택한 간선 수

            /*
             * <Kruskal 알고리즘>
             *
             * 가중치가 작은 간선부터 선택
             * 사이클이 발생하지 않으면 MST에 포함
             */
            for (Edge edge : edges) {

                // 서로 다른 집합이면 연결
                if (union(edge.from, edge.to)) {
                    res += edge.weight;
                    cnt++;

                    // MST 완성
                    if (cnt == v - 1) break;
                }
            }

            System.out.println("#" + test_case + " " + res);
        }
    }

    /*
     * <Union-Find>
     * 서로소 집합을 관리하는 알고리즘
     * 각 정점이 어떤 집합에 속해있는지 빠르게 확인 가능
     *
     * find(x): x의 루트 찾기
     * union(a, b): a와 b를 같은 집합으로 합치기
     *
     * 간선 선택 시 사이클 발생 여부를 빠르게 확인하기 위해 Kruskal 알고리즘에서 사용
     *
     * 두 정점의 부모가 같다면 이미 연결된 상태 -> 사이클 발생
     * 부모가 다르면 서로 다른 집합 -> 연결 가능
     */
    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parent[rootB] = rootA;
        return true;
    }
}