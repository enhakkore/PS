import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        //3과 5로 만들 수 있는 수 인가
        int three = 0;
        int five = 0;
        boolean result = true;

        if(n >= 3){
            three += n/3;
            n %= 3;
        }
        if( n > 0) {
            if(n == 2 && three > 0){
                three--;
                five++;
            } else if(n == 1 && three >= 3){
                three -= 3;
                five += 2;
            } else
                result = false;
        }

        if(result){
            StringBuilder sb = new StringBuilder();

            int t3 = 3*three;
            while(t3-- > 0){
                sb.append("5");
            }

            int t5 = 5*five;
            while( t5-- > 0){
                sb.append("3");
            }

            System.out.println(sb.toString());
        } else
            System.out.println("-1");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
