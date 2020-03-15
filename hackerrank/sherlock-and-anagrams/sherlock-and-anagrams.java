import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;

        for(int size = 1; size < s.length() ; size++){
            for(int stand = 0 ; stand < s.length() ; stand++){
                int stand_end = stand+size;
                if(stand_end < s.length() ){
                    String stand_string = s.substring(stand, stand_end);
                    for(int sub = stand + 1 ; sub < s.length() ; sub++){
                        int sub_end = sub+size;
                        if(sub_end <= s.length()){
                            String sub_string = s.substring(sub, sub_end);
                            if(check2(stand_string, sub_string)) count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    static boolean check2(String a, String b){
        List<String> b_tmp = new LinkedList<>();

        for(char c : b.toCharArray()){
            String cc = String.valueOf(c);
            b_tmp.add(cc);
        }

        for(int i = 0; i < a.length() ; i++){
            String tmp = String.valueOf(a.charAt(i));
            if(b_tmp.contains(tmp)){
                b_tmp.remove(tmp);
            } else return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
