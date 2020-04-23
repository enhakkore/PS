import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(long p, long q) throws IOException {
        /*
            1. n의 digit
            2. n*n
            3. n*n의 스트링 구하기
            4. 구한 스트링에서 0부터 {s.length() - n의 digit} 만큼 l, 그 뒤로는 r
            5. l과 r을 각각 정수로 만들어 더해서 n이면 n 저장.
            6. kaprekar num이 아예 없으면 INVALID RANGE 를 출력.
        */

        List<String> ans = new ArrayList<>();

        LongStream.rangeClosed(p, q).forEach( n -> {
            int digit = checkDigit(n);
            long squareN = n*n;
            String mid = String.valueOf(squareN);
            String l = mid.substring(0, mid.length()-digit);
            String r = mid.substring(mid.length()-digit, mid.length());

            int ll;
            if(l.length() == 0) ll = 0;
            else ll = Integer.parseInt(l);
            int rr = Integer.parseInt(r);

            if(ll+rr == n) ans.add(String.valueOf(n));
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(ans.size() == 0)
            bw.write("INVALID RANGE");
        else
            bw.write(ans.stream().collect(Collectors.joining(" ")));

        bw.flush();
        bw.close();

    }

    static int checkDigit(long n){
        int count = 0;
        while(n > 0){
            count++;
            n /= 10;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        long p = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long q = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
