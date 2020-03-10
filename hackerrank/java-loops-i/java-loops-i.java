import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringBuilder ans = cal(n);
        bw.write(ans.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    public static StringBuilder cal(int n){
        StringBuilder sb = new StringBuilder();
        String mul = " x ";
        String equal = " = ";

        for(int i = 1 ; i <= 10 ; i++){
            int result = n*i;
            sb.append(n);
            sb.append(mul);
            sb.append(i);
            sb.append(equal);
            sb.append(result);
            sb.append("\n");
        }

        return sb;
    }
}
