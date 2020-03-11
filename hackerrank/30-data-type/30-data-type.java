import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int ti = scan.nextInt();
        double td = scan.nextDouble();
        scan.nextLine();
        String ts = scan.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(i+ti);
        sb.append("\n");
        sb.append(d+td);
        sb.append("\n");
        sb.append(s);
        sb.append(ts);

        System.out.print(sb.toString());

        scan.close();
    }
}
