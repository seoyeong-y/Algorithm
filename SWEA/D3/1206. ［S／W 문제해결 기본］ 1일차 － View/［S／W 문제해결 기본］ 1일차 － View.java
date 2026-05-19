import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[n];

            for (int i = 0; i < n; i++)
                buildings[i] = Integer.parseInt(st.nextToken());

            int res = 0;

            for (int j = 2; j < n-2; j++) {
                int max = buildings[j-2];

                if (buildings[j-1] > max) max = buildings[j-1];
                if (buildings[j+1] > max) max = buildings[j+1];
                if (buildings[j+2] > max) max = buildings[j+2];

                if (buildings[j] > max)
                    res += buildings[j] - max;
            }

            System.out.println("#" + test_case + " " + res);
        }
    }
}