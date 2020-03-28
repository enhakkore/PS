import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] info = new int[26];

        for(char tmp : s.toCharArray()){
            info[tmp-'a']++;
        }

        Set<Integer> indexes = new HashSet<>();
        boolean flag = true, ans = true;
        int stand = 0;
        for(int i = 0; i < 26 ; i++){
            if(info[i] > 0){
                indexes.add(i);
                if(flag){
                    stand = info[i];
                    flag = false;
                } else if(info[i] != stand){
                    ans = false;
                    // break;
                }
            }
        }
        if(ans) return "YES";

        Set<Integer> indexes2 = new HashSet<>(indexes.stream().collect(Collectors.toList()));

        for(int index : indexes){
            info[index]--;
            if(info[index] == 0) indexes2.remove(index);

            flag = true;
            stand = 0;
            boolean isEqual = true;
            int lastIndex = 0;
            for(int tmp : indexes2){
                lastIndex = tmp;
                if(flag){
                    stand = info[tmp];
                    flag = false;
                } else if(stand != info[tmp]){
                    isEqual = false;
                    break;
                }
            }

            if(isEqual) return "YES";

            if(info[index] == 0) indexes2.add(index);
            info[index]++;
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
