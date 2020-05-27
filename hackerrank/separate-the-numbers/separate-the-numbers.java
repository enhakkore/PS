import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        boolean result = false;

        long prefix = 0L;
        for(int i = 1 ; i <= s.length()/2 ; i++){
            String sub = s.substring(0, i);
            prefix = Long.parseLong(sub);
            long tmp = prefix;
            String mid = sub;

            while(mid.length() < s.length()){
                mid += String.valueOf(++tmp);
            }

            if(mid.equals(s)){
                result = true;
                break;
            }
        }

        System.out.println(result ? "YES " + prefix : "NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
