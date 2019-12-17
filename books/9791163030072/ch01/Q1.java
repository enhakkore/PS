import java.util.Scanner;

public class App
{
    static int max4(int a, int b, int c, int d) {
        int max = Integer.MIN_VALUE ;
        if(max < a) max = a;
        if(max < b) max = b;
        if(max < c) max = c;
        if(max < d) max = d;
        return max;
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int ans = max4(a, b, c, d);

        System.out.print("answer : " + ans);
    }
}
