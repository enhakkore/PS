import java.util.Scanner;

public class App
{
    static int min4(int a, int b, int c, int d) {
        int min = Integer.MAX_VALUE ;
        if(min > a) min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        if(min > d) min = d;
        return min;
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int ans = min4(a, b, c, d);

        System.out.print("answer : " + ans);
    }
}
