import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int j = 0 ; j < n ; j++){
                int result = cal(a, b, j);
                sb.append(result);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        in.close();
    }

    public static int cal(int a, int b, int n){
        int mid = 0;
        for(int i = 0 ; i <= n ; i++){
            double x = Math.pow(2, i);
            mid += (int)x * b;
        }
        return a + mid;
    }
}
