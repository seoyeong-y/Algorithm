import java.util.HashSet;
import java.util.Scanner;

class Solution {
    static int n, l;
    static int[] scores;
    static int[] cals;
    static int max;
    static HashSet<String> visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int test_case = 1; test_case <= tc; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();

            scores = new int[n];
            cals = new int[n];

            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
                cals[i] = sc.nextInt();
            }

            max = 0;

            findMax(0, 0, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void findMax(int idx, int score, int cal) {
        if (cal > l) return;

        if (idx == n) {
            max = Math.max(max, score);
            return;
        }

        // 현재 재료를 선택하는 경우
        findMax(idx + 1, score + scores[idx], cal + cals[idx]);

        // 현재 재료를 선택하지 않는 경우
        findMax(idx + 1, score, cal);
    }
}