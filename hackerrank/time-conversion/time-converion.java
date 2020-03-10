import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String[] info = s.split(":");

        int th = Integer.parseInt(info[0]);

        if(info[2].charAt(2) == 'A'){
            if(th >= 12) th -= 12;
        } else {
            if(th < 12) th += 12;
        }

        StringBuilder sb = new StringBuilder();
        if(th < 10) sb.append("0");
        sb.append(th);
        sb.append(":");
        sb.append(info[1]);
        sb.append(":");
        sb.append(info[2].substring(0, 2));

        return sb.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
