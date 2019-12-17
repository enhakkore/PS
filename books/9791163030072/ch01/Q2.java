import java.util.Scanner;

public class App
{
    static int min3(int a, int b, int c) {
        int min = Integer.MAX_VALUE ;
        if(min > a) min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        return min;
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int ans = min3(a, b, c);

        System.out.print("answer : " + ans);
    }
}
