import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    // 조합 값을 MOD로 나눈 나머지를 구하는 문제
    static final long MOD = 1234567891L;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // n!
            long num = factorial(n);

            // r!(n-r)!
            long denom = factorial(r) * factorial(n-r) % MOD;

            /*
            * 조합 공식
            * nCr = n! / (r!(n-r)!)
            *
            * 모듈러 연산에서는 나눗셈이 불가능하므로
            * 페르마의 소정리를 이용하여 분모의 역원을 곱해야 함
             */
            long res = num * pow(denom, MOD - 2) % MOD;

            System.out.println("#" + test_case + " " + res);
        }
    }

    // 팩토리얼 메서드
    // overflow 방지 위해 MOD 연산 수행
    static long factorial(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++)
            result = result * i % MOD;

        return result;
    }

    // 거듭제곱을 구하는 분할 정복 메서드
    // 분모의 역원을 계산하는 데 사용
    static long pow(long base, long exp) {
        long result = 1;

        /*
        * 분할 정복 기반 빠른 거듭제곱
        * -> 지수를 절반씩 줄이면서 계산
        *
        * 홀수 지수: a^11 = a*(a^5)^2
        * 짝수 지수: a^10 = (a^5)^2
        *
        * exp가 홀수이면 base 1개를 result에 먼저 곱해야 함
         */
        while (exp > 0) {
            if (exp % 2 == 1)
                result = result * base % MOD;

            base = base * base % MOD;
            exp /= 2;
        }

        return result;
    }
}