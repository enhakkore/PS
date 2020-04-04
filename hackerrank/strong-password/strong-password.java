import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for(char cur : password.toCharArray() ){
            String tmp = String.valueOf(cur);

            if(numbers.contains(tmp)){
                hasNumber = true;
            } else if(lower_case.contains(tmp)){
                hasLowerCase = true;
            } else if(upper_case.contains(tmp)){
                hasUpperCase = true;
            } else if(special_characters.contains(tmp)){
                hasSpecial = true;
            }
        }

        int need_length = 6-n;
        int tmp_len = 0;

        if(!hasLowerCase) tmp_len++;
        if(!hasUpperCase) tmp_len++;
        if(!hasNumber) tmp_len++;
        if(!hasSpecial) tmp_len++;

        return tmp_len >= need_length ? tmp_len : need_length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
