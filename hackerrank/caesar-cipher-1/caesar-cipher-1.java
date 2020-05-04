import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        return s.chars().map(c->{
            char base = (char)c;
            if((base < 'a' || base > 'z') && (base < 'A' || base > 'Z')){
                return c;
            }

            int tk = k % 26;
            int res = c + tk;
            if( c <= 'Z' && c >= 'A'){
                if(res > 'Z'){
                    res = 'A'+res-'Z'-1;
                }
            } else if(res > 'z'){
                res = 'a' + res - 'z'-1;
            }

            return res;
        }).mapToObj(c2 -> Character.toString((char)c2)).collect(Collectors.joining());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
