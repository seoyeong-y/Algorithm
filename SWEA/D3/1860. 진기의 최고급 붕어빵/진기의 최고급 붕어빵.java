import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            
            // key: 도착 시간, value: 해당 시간에 도착한 손님 수
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int t = Integer.parseInt(st.nextToken());
                map.put(t, map.getOrDefault(t, 0) + 1);
            }

            int cnt = 0; // 남아 있는 붕어빵 개수
            boolean isPossible = true;

            int max = Collections.max(map.keySet()); // 마지막 손님 도착 시간

            for (int time = 0; time <= max; time++) {
                if (time > 0 && time % m == 0) cnt += k;

                // 현재 시간에 도착한 손님 수
                int custCnt = map.getOrDefault(time, 0);

                if (cnt < custCnt) {
                    isPossible = false;
                    break;
                }

                // 도착한 손님들에게 붕어빵 제공
                cnt -= custCnt;
            }

            System.out.println("#" + test_case + " " + (isPossible ? "Possible" : "Impossible"));
        }
    }
}