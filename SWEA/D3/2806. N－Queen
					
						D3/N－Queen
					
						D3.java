import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int n;
    static int[] col;
    static int res;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            n = Integer.parseInt(br.readLine());
            col = new int[n+1];
            res = 0;

            dfs(0);

            System.out.println("#" + test_case + " " + res);
        }
    }

    static void dfs(int row) {
        // n개의 퀸을 모두 배치한 경우
        if (row == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            col[row] = i; // 현재 row에서 i번째 열에 퀸 배치
            if (isPossible(row))
                dfs(row + 1);
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나 대각선에 있는지 확인
            if (col[row] == col[i] || Math.abs(row-i) == Math.abs(col[row] - col[i]))
                return false;
        }
        return true;
    }
}