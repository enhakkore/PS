import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        int n = 1;
        while((input = br.readLine()) != null){
            bw.write(String.valueOf(n++));
            bw.write(" ");
            bw.write(input);
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
