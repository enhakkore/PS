import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {

        int len = s.length();
        double val = Math.sqrt(len);
        double ceil = Math.ceil(val);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < ceil ; i++){
            for(int j = 0 ; j < len ; j+= ceil){
                if(i+j >= len) break;
                sb.append(s.charAt(i+j));
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
