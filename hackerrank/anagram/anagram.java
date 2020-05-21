import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        if(s.length() % 2 != 0) return -1;

        char[] arr = s.toCharArray();
        int[] left = new int[26];
        int[] right = new int[26];

        int i;
        for(i = 0 ; i < s.length()/2 ; i++) left[arr[i]-'a']++;
        for( ; i < s.length() ; i++) right[arr[i]-'a']++;

        Cal cal = new Cal();
        s.substring(0, s.length()/2).chars().distinct().forEach( e -> {
            int idx = e-'a';
            if(left[idx] > right[idx])
                cal.sum(left[idx]-right[idx]);
        });

        return cal.count;
    }

    public static class Cal {
        public int count = 0;
        public void sum(int t){
            count += t;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
