// this code has a time out to 10, 12, 13 and 14 test case.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();

        int i = a.length() - 1, j = b.length() - 1;

        if(check(a_arr, b_arr, i, j)) return "YES";
        else return "NO";
    }

    static boolean check(char[] a_arr, char[] b_arr, int i, int j){
        if(i < 0 || j < 0){
            if(i < 0 && j >= 0) return false;
            if(i >= 0 && j < 0){
                for(int k = i ; k >= 0 ; k--){
                    if(Character.isUpperCase(a_arr[k]))
                        return false;
                }
                return true;
            }
            return true;
        }

        if(a_arr[i] == b_arr[j]){
            return check(a_arr, b_arr, i-1, j-1);
        }

        if(Character.isLowerCase(a_arr[i])){
            boolean result = false;
            if(Character.toUpperCase(a_arr[i]) == b_arr[j]){
                result = check(a_arr, b_arr, i-1, j-1);
            }

            return result || check(a_arr, b_arr, i-1, j);
        } else return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
