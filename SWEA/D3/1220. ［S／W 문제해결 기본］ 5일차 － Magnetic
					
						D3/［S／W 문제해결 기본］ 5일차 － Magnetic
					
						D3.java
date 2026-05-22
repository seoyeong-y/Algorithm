import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int res = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int next = 1; next < 100 - j; next++) {
                        if (arr[j][i] == 1) {
                            if (arr[j + next][i] == 2) {
                                res++;
                            } else continue;
                        } else continue;

                        j += next;
                    }
                }
            }

            System.out.println("#" + test_case + " " + res);
        }
    }
}