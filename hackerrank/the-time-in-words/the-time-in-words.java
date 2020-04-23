import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String[] stock = {" o' ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half", "minute ", "minutes ", "clock"};

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        StringBuilder sb = new StringBuilder();

        if(m == 0){
            sb.append(stock[h]);
            sb.append(stock[0]);
            sb.append(stock[33]);
        } else if(m > 30){
                m = 60 - m;
                sb.append(stock[m]);
                sb.append(" ");

                if( m % 15 != 0){
                    if(m != 1) sb.append(stock[32]);
                    else sb.append(stock[31]);
                }

                sb.append("to ");
                sb.append(stock[h+1]);
        } else {
            sb.append(stock[m]);
            sb.append(" ");

            if( m % 15 != 0){
                if(m != 1) sb.append(stock[32]);
                else sb.append(stock[31]);
            }

            sb.append("past ");
            sb.append(stock[h]);
        }

        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
