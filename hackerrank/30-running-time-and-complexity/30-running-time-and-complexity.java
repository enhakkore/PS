import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String Prime = "Prime";
        final String NotPrime = "Not prime";

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            if( n == 1 || (n != 2 && n % 2 == 0)){
                bw.write(NotPrime);
            } else {
                boolean flag = true;
                for(int i = 3 ; i*i <= n ; i++){
                    if(n % i == 0){
                        bw.write(NotPrime);
                        flag = false;
                        break;
                    }
                }
                if(flag) bw.write(Prime);
            }
            bw.newLine();
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
