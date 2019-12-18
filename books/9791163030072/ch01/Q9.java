import java.util.Scanner;

public class App
{

    public static int sumOf(int a, int b) {

        if( a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int sum = 0;
        for(int i = a; i <= b ; i++){
            sum += i;
        }

        return sum;
    }
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("합 : "+sumOf(a, b));
    }
}
