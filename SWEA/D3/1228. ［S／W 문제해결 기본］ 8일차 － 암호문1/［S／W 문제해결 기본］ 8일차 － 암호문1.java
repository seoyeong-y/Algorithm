import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int len = Integer.parseInt(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cmdCnt = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < cmdCnt; i++) {
                char cmd = st.nextToken().charAt(0); // 삽입 명령어 I

                int x = Integer.parseInt(st.nextToken()); // 삽입 위치 x
                int y = Integer.parseInt(st.nextToken()); // 삽입 개수 y

                for (int j = 0; j < y; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    list.add(x + j, num);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case);

            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(list.get(i));
            }

            System.out.println(sb);
        }
    }
}