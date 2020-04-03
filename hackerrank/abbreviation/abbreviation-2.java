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

        boolean[][] check = new boolean[a.length()+1][b.length()+1];

        boolean flag = false;
        for(int i = 1 ; i <= a.length() ; i++){
            int index = i-1;
            if(Character.isUpperCase(a_arr[index]) || flag){
                flag = true;
                check[i][0] = false;
            } else check[i][0] = true;
        }

        check[0][0] = true;

        for(int i = 1 ; i <= a.length() ; i++){
            for(int j = 1 ; j <=b.length() ; j++){
                int a_index = i-1, b_index = j-1;

                if(a_arr[a_index] == b_arr[b_index]){
                    check[i][j] = check[i-1][j-1];
                    continue;
                }

                if(Character.isLowerCase(a_arr[a_index])){
                    if(Character.toUpperCase(a_arr[a_index]) == b_arr[b_index]){
                        check[i][j] = check[i-1][j-1] || check[i-1][j];
                        continue;
                    }

                    check[i][j] = check[i-1][j];
                    continue;
                }

                check[i][j] = false;
            }
        }

        return check[a.length()][b.length()] ? "YES" : "NO";
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
