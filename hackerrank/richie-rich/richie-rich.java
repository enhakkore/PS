// Hackerrank - Highest Value Palindrome

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        char[] temp = s.toCharArray();
        ArrayList<Integer> stock = new ArrayList<>();

        for(int left_index = 0; left_index < n/2 ; left_index++){
            int right_index = n - left_index - 1;
            if(temp[left_index] != temp[right_index]){
                stock.add(left_index);

                if(temp[left_index] > temp[right_index]){
                    temp[right_index] = temp[left_index];
                } else {
                    temp[left_index] = temp[right_index];
                }

                k--;
            }
        }

        if(k < 0) return "-1";

        int left_index = 0;
        while(k > 0 && left_index < n/2){
            if(temp[left_index] != '9'){
                int right_index = n - left_index - 1;

                if(stock.contains(left_index)){
                    temp[left_index] = temp[right_index] = '9';
                    k--;
                } else if(k > 1){
                    temp[left_index] = temp[right_index] = '9';
                    k -= 2;
                }
            }
            left_index++;
        }

        if(n % 2 != 0 && k > 0){
            temp[n/2] = '9';
        }

        return String.valueOf(temp);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
