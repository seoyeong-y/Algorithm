import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] weight = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++)
                weight[i] = Integer.parseInt(st.nextToken());
            
            int max = -1;

            for (int i = 0; i < n-1; i++) {
                for (int j = 1; j < n; j++) {
                    if (i != j) {
                        int sum = weight[i] + weight[j];
                        if (sum <= m && sum > max)
                            max = sum;
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}