import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("0001101", 0); map.put("0011001", 1); map.put("0010011", 2);
        map.put("0111101", 3); map.put("0100011", 4); map.put("0110001", 5);
        map.put("0101111", 6); map.put("0111011", 7); map.put("0110111", 8);
        map.put("0001011", 9);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String code = "";
            String[] password = new String[8];

            for (int i = 0; i < n; i++) {
                String input = br.readLine();

                if (input.contains("1")) {
                    code = input;
                    int end = code.lastIndexOf("1");

                    // 56자리 코드 추출
                    String fullCode = code.substring(end - 55, end + 1);

                    // 7자리씩 8개로 나누기
                    for (int j = 0; j < 8; j++)
                        password[j] = fullCode.substring(j * 7, j * 7 + 7);
                }
            }

            int result = 0;
            int sum = 0;

            for (int i = 0; i < 8; i++) {
                int value = map.get(password[i]);
                if (i % 2 == 0)
                    result += 3 * value;
                else
                    result += value;
                sum += value;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            if (result % 10 == 0) sb.append(sum);
            else sb.append(0);

            System.out.println(sb);
        }
    }
}