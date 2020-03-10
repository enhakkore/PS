import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

private static boolean flag = true;
private static int B;
private static int H;
private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

static {
    try{
        B = Integer.parseInt(br.readLine());
        H = Integer.parseInt(br.readLine());

        if(B <= 0 || H <= 0){
            bw.write("java.lang.Exception: Breadth and height must be positive");
            bw.flush();
            flag = false;
        }
    }
    catch(Exception e){
        ;
    }
}

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}

	}//end of main

}//end of class
