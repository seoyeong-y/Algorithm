import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println("#" + test_case + " " + power(N, M));
        }
    }

    static int power(int n, int m) {
        if (m == 0)
            return 1;

        return n * power(n, m - 1);
    }
}