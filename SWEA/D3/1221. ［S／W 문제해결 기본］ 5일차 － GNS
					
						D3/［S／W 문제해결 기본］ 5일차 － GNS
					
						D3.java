import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    static String[] gns = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tc = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];

            for (int i = 0; i < cnt; i++) {
                String str = st.nextToken();
                for (int j = 0; j < 10; j++) {
                    if (str.equals(gns[j])) {
                        arr[j]++;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(tc);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < arr[i]; j++) 
                    sb.append(" ").append(gns[i]);
            }

            System.out.println(sb);
        }
    }
}