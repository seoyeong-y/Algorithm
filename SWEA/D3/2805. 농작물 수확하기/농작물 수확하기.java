import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++)
                    arr[i][j] = str.charAt(j) - '0';
            }

            int mid = n / 2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int start = Math.abs(mid - i);
                int end = n - 1 - Math.abs(mid - i);

                for (int j = start; j <= end; j++)
                    sum += arr[i][j];
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}