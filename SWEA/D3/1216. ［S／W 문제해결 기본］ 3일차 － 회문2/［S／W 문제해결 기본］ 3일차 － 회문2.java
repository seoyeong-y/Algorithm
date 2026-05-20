import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static char[][] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = Integer.parseInt(br.readLine());
            arr = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++)
                    arr[i][j] = str.charAt(j);
            }

            int res = 1;

            // 긴 길이부터 확인
            for (int len = 100; len >= 1; len--) {
                if (hasPalindrome(len)) {
                    res = len;
                    break;
                }
            }

            System.out.println("#" + tc + " " + res);
        }
    }

    // 길이가 len인 회문이 가로 또는 세로에 있는지 확인
    static boolean hasPalindrome(int len) {
        for (int i = 0; i < 100; i++) {
            for (int start = 0; start <= 100 - len; start++) {
                if (isRow(i, start, len)) return true;
                if (isCol(start, i, len)) return true;
            }
        }
        return false;
    }

    // row행에서 start부터 len만큼 가로 회문인지 검사
    static boolean isRow (int row, int start, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (arr[row][start + i] != arr[row][start + len - 1 - i])
                return false;
        }
        return true;
    }

    // col열에서 start부터 len만큼 세로 회문인지 검사
    static boolean isCol(int start, int col, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (arr[start + i][col] != arr[start + len - 1 - i][col])
                return false;
        }
        return true;
    }
}