import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int[] fromFront = Arrays.copyOf(B, B.length);
        int[] fromBehind = Arrays.copyOf(B, B.length);
        int[] ans = new int[2];

        int bCount = 0;
        for(int i = B.length-1; i > 0 ; i--){
            if(fromBehind[i] % 2 != 0){
                fromBehind[i]++;
                fromBehind[i-1]++;
                bCount += 2;
            }
        }

        if(fromBehind[0] % 2 != 0) ans[1] = 5000;
        else ans[1] = bCount;

        int fCount = 0;
        for(int i = 0; i < B.length-1 ; i++){
            if(fromFront[i] % 2 != 0){
                fromFront[i]++;
                fromFront[i+1]++;
                fCount += 2;
            }
        }

        if(fromFront[B.length-1] % 2 != 0) ans[0] = 5000;
        else ans[0] = fCount;

        return Math.min(ans[0], ans[1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        if(result == 5000) bufferedWriter.write("NO");
        else bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
