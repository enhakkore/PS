import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        //방법1
        // StringBuilder sb = new StringBuilder();
        // while( n > 0){
        //     int a = n / 2;
        //     int b = n % 2;
        //     sb.append(b);
        //     n /= 2;
        // }
        // String result = sb.reverse().toString();

        //방법2
        String result = Integer.toBinaryString(n);

        int max = 0;
        int cur = 0;
        for(char tmp : result.toCharArray()){
            if(tmp == '0'){
                max = Math.max(cur, max);
                cur = 0;
            } else {
                cur++;
            }
        }
        max = Math.max(cur, max);

        System.out.print(max);

        scanner.close();
    }
}
