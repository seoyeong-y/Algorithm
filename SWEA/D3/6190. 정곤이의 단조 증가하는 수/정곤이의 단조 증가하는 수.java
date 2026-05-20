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
            int cnt = st.countTokens();
            int[] num = new int[cnt];

            for (int i = 0; i < cnt; i++)
                num[i] = Integer.parseInt(st.nextToken());

            int max = -1;

            for (int j = 0; j < cnt-1; j++) {
                for (int l = j+1; l < cnt; l++) {
                    String result = String.valueOf(num[j] * num[l]);
                    boolean isMono = true;
                    
                    for (int len = 0; len < result.length()-1; len++) {
                        if (result.charAt(len) > result.charAt(len+1)) {
                            isMono = false;
                            break;
                        }
                    }
                    if (isMono && max < num[j] * num[l]) max = num[j] * num[l];
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}