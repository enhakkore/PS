import java.util.Scanner;

public class App
{
    static void spira(int n, StringBuilder sb) {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = n ; j > i ; j--)
                sb.append(" ");

            for(int k = 1 ; k <= (i-1)*2+1 ; k++)
                sb.append("*");

            sb.append("\n");
        }
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        spira(n, sb);

        System.out.print(sb.toString());
    }
}
