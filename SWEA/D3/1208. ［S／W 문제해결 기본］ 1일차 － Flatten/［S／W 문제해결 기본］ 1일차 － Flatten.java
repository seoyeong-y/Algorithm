import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int max, maxIdx, min, minIdx;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            int[] boxes = new int[count];
            int maxIndex, minIndex;

            for (int i = 0; i < count; i++)
                boxes[i] = Integer.parseInt(st.nextToken());

            for (int dump = 0; dump < n; dump++) {
                maxIndex = findMaxIdx(boxes);
                minIndex = findMinIdx(boxes);

                boxes[maxIndex]--; boxes[minIndex]++;
            }

            int[] res = new int[2];
            res[0] = boxes[findMaxIdx(boxes)];
            res[1] = boxes[findMinIdx(boxes)];

            System.out.println("#" + test_case + " " + (res[0] - res[1]));
        }
    }

    static int findMaxIdx(int[] arr) {
        max = arr[0];
        maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    static int findMinIdx(int[] arr) {
        min = arr[0];
        minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }

        return minIdx;
    }
}