import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, ArrayDeque<Integer>> info = new HashMap<>();

        for(int i = 0 ; i < cost.length ; i++){
            int tmp = cost[i];
            if(info.containsKey(tmp)){
                ArrayDeque<Integer> tmp_stock = info.get(tmp);
                tmp_stock.offer(i);
            } else {
                ArrayDeque<Integer> tmp_stock = new ArrayDeque<>();
                tmp_stock.offer(i);
                info.put(tmp, tmp_stock);
            }
        }

        int[] ans = new int[2];
        for(int i = 0 ; i < cost.length ; i++){
            int tmp = cost[i];
            int rem = money-tmp;
            if(info.containsKey(rem)){
                ArrayDeque<Integer> rem_stock = info.get(rem);
                int index = rem_stock.peek();

                if(index == i){
                    if(rem_stock.size() == 1) continue;

                    while(index==i){
                        index = rem_stock.poll();
                        rem_stock.offer(index);
                    }
                }

                ans[0] = i+1;
                ans[1] = index+1;
                break;
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[0]+" "+ans[1]);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
