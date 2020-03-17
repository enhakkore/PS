/*
* following code is failed on Test case 14 only.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] stock = new int[26];

        for(char tmp : s.toCharArray()){
            stock[tmp-'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(stock[i] == 0) continue;
            stock[i]--;
            boolean result = true;
            if(stock[i] == 0){
                boolean find = false;
                int stand = 0;
                for(int tmp : stock){
                    if(tmp == 0) continue;
                    if(find){
                        if(tmp != stand){
                            result = false;
                            break;
                        }
                    }else{
                        stand = tmp;
                        find = true;
                    }
                }
            }else {
                int stand = stock[i];
                for(int tmp : stock){
                    if(tmp == 0) continue;
                    if(tmp != stand){
                        result = false;
                        break;
                    }
                }
            }
            if(result) return "YES";
            stock[i]++;
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
