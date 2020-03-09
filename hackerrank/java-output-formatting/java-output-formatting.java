import java.util.Scanner;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
            // Scanner sc=new Scanner(System.in);
            // System.out.println("================================");
            // for(int i=0;i<3;i++)
            // {
            //     String s1=sc.next();
            //     int x=sc.nextInt();
            //     //Complete this line
            // }
            // System.out.println("================================");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder ans = new StringBuilder();

        ans.append("================================");
        ans.append("\n");

        for(int i = 0 ; i < 3 ; i++){
            String[] tmp = br.readLine().split("\\s+");
            ans.append(tmp[0]);

            // ans.append(ws15.toString());
            for(int j = 0 ; j < 15-tmp[0].length(); j++)
                ans.append(" ");

            int num = Integer.parseInt(tmp[1]);
            if(num < 100) ans.append("0");
            if(num < 10) ans.append("0");
            ans.append(tmp[1]);
            ans.append("\n");
        }

        ans.append("================================");

        bw.write(ans.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
