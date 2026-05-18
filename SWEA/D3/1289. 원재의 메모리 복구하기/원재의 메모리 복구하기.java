import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String memory = br.readLine();
            int count = 0;
            char bit = '0';

            for (int i = 0; i < memory.length(); i++) {
                if (memory.charAt(i) != bit) {
                    count++;
                    bit = memory.charAt(i);
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}