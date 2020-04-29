import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        final String yes = "YES";
        final String no = "NO";

        char[] bArray = b.toCharArray();
        int[] info = new int[26];
        int underCount = 0;

        for(char tmp : bArray){
            if(tmp == '_') underCount++;
            else info[tmp-'A']++;
        }

        int oneCount = (int)Arrays.stream(info).filter( n -> n==1).count();
        if(oneCount != 0) return no;

        if(underCount == 0) {
            int check = 0;
            char stand = '0';
            boolean flag = true;

            for(char tmp : bArray){
                if( check > 0){
                    if(stand == tmp){
                        check++;
                    } else if( check == 1){
                        flag = false;
                        break;
                    } else {
                        stand = tmp;
                        check = 1;
                    }
                } else if(check == 0){
                    stand = tmp;
                    check++;
                }
            }

            if(flag) return yes;
            return no;
        }

        return yes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
