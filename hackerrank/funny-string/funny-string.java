import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static final String f = "Funny";
    static final String nf = "Not Funny";

    // Complete the funnyString function below.
    static String funnyString(String s) {
        int[] info = new int[s.length()-1];
        for(int i = 0 ; i < s.length() - 1; i++){
            info[i] = Math.abs(s.charAt(i) - s.charAt(i+1));
        }

        boolean flag = true;
        for(int i = s.length()-1 ; i > 0 ; i--){
            int temp = Math.abs(s.charAt(i)-s.charAt(i-1));
            if(info[s.length()-1-i] != temp){
                flag = false;
                break;
            }
        }

        if(flag) return f;
        else return nf;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
