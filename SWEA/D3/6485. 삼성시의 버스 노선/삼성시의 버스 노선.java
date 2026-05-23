import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[] busStop = new int[5001];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for (int j = a; j <= b; j++) {
                    busStop[j]++;
                }
            }

            int p = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case);

            for (int i = 0; i < p; i++) {
                int c = Integer.parseInt(br.readLine());
                sb.append(" ").append(busStop[c]);
            }

            System.out.println(sb);
        }
    }
}