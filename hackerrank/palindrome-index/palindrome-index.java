import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();

        boolean flag = false;
        int temp = right;
        int index = -1;
        while(left < right){
            if(arr[left] == arr[right]){
                left++;
                right--;
            } else if(flag){
                index = temp;
                break;
            } else if(arr[left+1] == arr[right]){
                index = left;
                temp = right;
                flag = true;
                left++;
            } else if(arr[left] == arr[right-1]){
                index = right;
                temp = left;
                flag = true;
                right--;
            }
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
