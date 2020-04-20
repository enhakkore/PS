import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, HashMap<Integer, List<Integer>> obsta) {
        int ans = 0;

        int[] tr = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] tc = {1, 0, -1, 0, 1, -1, -1, 1};

        for(int i = 0 ; i < 8 ; i++){
            int cur_r = r_q;
            int cur_c = c_q;

            while(true){
                cur_r += tr[i];
                cur_c += tc[i];

                if(cur_r < 1 || cur_c < 1 || cur_r > n || cur_c > n) break;

                if(obsta.containsKey(cur_r)){
                    if(obsta.get(cur_r).contains(cur_c)){
                        break;
                    }
                }
                ans++;
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        HashMap<Integer, List<Integer>> obsta = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int ob_r = Integer.parseInt(obstaclesRowItems[0]);
            int ob_c = Integer.parseInt(obstaclesRowItems[1]);

            List<Integer> mid = obsta.getOrDefault(ob_r, new ArrayList<>());
            mid.add(ob_c);
            obsta.put(ob_r, mid);
        }

        int result = queensAttack(n, k, r_q, c_q, obsta);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
