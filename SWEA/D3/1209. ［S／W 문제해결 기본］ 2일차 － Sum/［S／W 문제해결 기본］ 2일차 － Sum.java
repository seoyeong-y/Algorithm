import java.io.BufferedReader;
import java.io.InputStreamReader;
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

            int res = findMax(arr);

            System.out.println("#" + n + " " + res);
        }
    }

    // 행, 열, 대각선 합 중 최댓값 탐색
    static int findMax (int[][] arr) {
        int maxTotal = 0;

        for (int i = 0; i < arr.length; i++) {
            maxTotal += arr[0][i];
        }


        // 행의 합
        for (int row = 1; row < arr.length; row++) {
            int sumRow = 0;
            for (int num : arr[row])
                sumRow += num;
            if (sumRow > maxTotal) maxTotal = sumRow;
        }

        // 열의 합
        for (int col = 1; col < arr.length; col++) {
            int sumCol = 0;
            for (int[] rowArr : arr)
                sumCol += rowArr[col];
            if (sumCol > maxTotal) maxTotal = sumCol;
        }

        int sumDiag1 = 0;
        int sumDiag2 = 0;

        // 대각선의 합
        for (int i = 0; i < arr.length; i++) {
            sumDiag1 += arr[i][i];
            sumDiag2 += arr[i][arr.length-i-1];
        }

        if (sumDiag1 > maxTotal) maxTotal = sumDiag1;
        if (sumDiag2 > maxTotal) maxTotal = sumDiag2;

        return maxTotal;
    }
}