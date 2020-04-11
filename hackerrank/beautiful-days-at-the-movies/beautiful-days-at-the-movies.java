import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the beautifulDays function below.
    // static int beautifulDays(int i, int j, int k) {
    //     int ans = 0;
    //     for(int target = i ; target <= j ; target++){
    //         StringBuilder sb = new StringBuilder();
    //         int reverse = Integer.parseInt(sb.append(target).reverse().toString());
    //         if(Math.abs(target-reverse)%k == 0) ans++;
    //     }

    //     return ans;

    // }

    static long beautifulDays(int i, int j, int k){
        return IntStream.rangeClosed(i, j).filter( cur -> {
            StringBuilder sb = new StringBuilder();
            int reverse = Integer.parseInt(sb.append(cur).reverse().toString());
            return Math.abs(cur - reverse) % k == 0;
        }).count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        long result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
