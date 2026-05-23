import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int n, k, res;
    static int[] arr;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            res = 0;
            dfs (0, 0);
            
            System.out.println("#" + test_case + " " + res);
        }
    }
    
    static void dfs(int idx, int sum) {
        if (sum == k) {
            res++;
            return;
        }
        
        if (idx == n) return;
        
        // 현재 원소 포함
        dfs(idx + 1, sum + arr[idx]);
        
        // 현재 원소 미포함
        dfs(idx + 1, sum);
    }
}