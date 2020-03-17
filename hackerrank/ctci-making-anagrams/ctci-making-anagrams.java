import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] a_info = check(a);
        int[] b_info = check(b);

        int count = 0;
        int num = 26;
        while(--num >= 0){
            count += Math.abs(a_info[num]-b_info[num]);
        }

        return count;
    }

    static int[] check(String subject){
        int[] stock = new int[26];

        for(char tmp : subject.toCharArray()){
            stock[tmp-'a']++;
        }

        return stock;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
