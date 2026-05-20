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

            st = new StringTokenizer(br.readLine());
            int[] num = new int[n];

            for (int i = 0; i < n; i++)
                num[i] = Integer.parseInt(st.nextToken());

            int max = getMax(n, num);

            System.out.println("#" + test_case + " " + max);
        }
    }

    // 단조 곱 중에서 최댓값 탐색
    private static int getMax(int n, int[] num) {
        int max = -1;

        for (int i = 0; i < n -1; i++) {
            for (int j = i+1; j < n; j++) {
                int res = num[i] * num[j];
                String strRes = String.valueOf(res);
                boolean isMono = true; // 단조 여부

                // 단조 여부 확인
                for (int len = 0; len < strRes.length()-1; len++) {
                    if (strRes.charAt(len) > strRes.charAt(len+1)) {
                        isMono = false;
                        break;
                    }
                }
                
                if (isMono && max < res) max = res;
            }
        }
        return max;
    }
}