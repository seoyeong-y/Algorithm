import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    static char[] arr;
    static int change;
    static int max;
    static HashSet<String> visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = st.nextToken().toCharArray();
            change = Integer.parseInt(st.nextToken());
            max = 0;
            visited = new HashSet<>();

            dfs(0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    // DFS + 백트래킹 + 가지치기 (HashSet)
    static void dfs(int count) {
        if (count == change) {
            int num = Integer.parseInt(String.valueOf(arr));
            if (num > max) max = num;
            return; // 현재 재귀 종료
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                swap(i, j);

                // 같은 교환 횟수에서 같은 숫자 상태 중복 탐색 확인
                String state = (count + 1) + " " + String.valueOf(arr);

                if (!visited.contains(state)) {
                    visited.add(state);
                    dfs(count + 1); // 다음 재귀 진행
                }

                swap(i, j);
            }
        }
    }

    static void swap (int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}