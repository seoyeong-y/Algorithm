import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int res = 0;

            for (int i = -n; i <= n; i++) {
                for (int j = -n; j <= n; j++) {
                    if (i * i + j * j <= n * n) res++;
                }
            }

            System.out.println("#" + test_case + " " + res);
        }
    }
}