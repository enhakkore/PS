import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int sum = 0;

        for(int i = 1 ; i <= n ; i++){
            sum += i;
            sb.append(i);
            if( i != n) sb.append(" + ");
            else sb.append(" = ");
        }

        sb.append(sum);

        System.out.print(sb.toString());
    }
}
