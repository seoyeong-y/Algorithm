import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String search = br.readLine();
            String result = search.replace(str, "");

            int res = (search.length() - result.length()) / str.length();

            System.out.println("#" + tc + " " + res);
        }
    }
}