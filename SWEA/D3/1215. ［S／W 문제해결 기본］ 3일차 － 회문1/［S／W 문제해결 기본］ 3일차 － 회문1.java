import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static char[][] arr;
    static int len;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            len = Integer.parseInt(br.readLine());
            arr = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++)
                    arr[i][j] = str.charAt(j);
            }

            int res = countPalindrome();

            System.out.println("#" + test_case + " " + res);
        }
    }

    // 길이가 len인 회문 개수 확인
    static int countPalindrome() {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int start = 0; start <= 8 - len; start++) {
                boolean isRow = true;
                boolean isCol = true;

                for (int j = 0; j < len / 2; j++) {
                    if (arr[i][start + j] != arr[i][start + len - 1 - j])
                        isRow = false;
                    if (arr[start + j][i] != arr[start + len - 1 - j][i])
                        isCol = false;
                }

                if (isRow) cnt++;
                if (isCol) cnt++;
            }
        }
        return cnt;
    }
}