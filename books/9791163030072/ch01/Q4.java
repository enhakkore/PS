import java.util.Scanner;

public class App
{
    static int findMedian(int a, int b, int c) {
        int ans = 0;

        if(a <= b) {
            if(a < b) {
                if (a >= c)
                    ans = a;
                else if( b <= c ) // a < c, a < b
                    ans = b;
                else ans = c;
            } else
                ans = a;
        } else if(b >= c) { // b < a
            ans = b;
        } else if( a >= c) // b < a, b < c
            ans = c;
        else ans = a;

        return ans;
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int ans = findMedian(a, b, c);

        System.out.print("answer : " + ans);
    }
}
