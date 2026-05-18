import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < str.length(); i++)
                set.add(str.charAt(i));

            System.out.println("#" + test_case + " " + set.size());
        }
    }
}