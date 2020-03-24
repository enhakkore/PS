import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length() == 1) return "NO";

        ArrayDeque<Character> stock = new ArrayDeque<>();

        boolean flag = false;
        for(int i = 0; i < s.length() ; i++ ){
            char tmp = s.charAt(i);
            if(tmp == ')' || tmp == '}' || tmp == ']') flag = true;

            if(flag){
                flag = false;
                if(stock.isEmpty()) return "NO";
                char tmp2 = stock.pop();
                switch(tmp) {
                    case ')' :
                        if(tmp2 != '(') return "NO";
                        break;
                    case '}' :
                        if(tmp2 != '{') return "NO";
                        break;
                    case ']' :
                        if(tmp2 != '[') return "NO";
                        break;
                }
            } else {
                stock.push(tmp);
            }
        }

        if(!stock.isEmpty()) return "NO";

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
