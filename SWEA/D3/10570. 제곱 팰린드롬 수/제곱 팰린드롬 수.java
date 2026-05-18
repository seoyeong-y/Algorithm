import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int test_case = 1; test_case <= tc; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = 0;

            for (int i = a; i <= b; i++) {
                if (i % Math.sqrt(i) == 0) {
                    if (palindrome(i) && palindrome((int)Math.sqrt(i)))
                        res++;
                }
            }

            System.out.println("#" + test_case + " " + res);
        }
    }

    static boolean palindrome(int n) {
        String s = String.valueOf(n);
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}