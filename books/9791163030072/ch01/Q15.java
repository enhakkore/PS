import java.util.Scanner;

public class App
{
    static void triangleLB(int n, StringBuilder sb){
        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
    }

    static void triangleLU(int n, StringBuilder sb) {
        for(int i = 1; i <= n ; i++){
            for(int j = n ; j >= i ; j--){
                sb.append("*");
            }
            sb.append("\n");
        }
    }

    static void triangleRU(int n, StringBuilder sb){
        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; i > j ; j++)
                sb.append(" ");

            for(int k = n ; k >= i ; k--){
                sb.append("*");
            }
            sb.append("\n");
        }
    }

    static void trianlgeRB(int n, StringBuilder sb){
        for(int i = 1 ; i <= n ; i++){
            for(int j = n ; j > i ; j--)
                sb.append(" ");
            for(int k = i ; k >= 1; k--)
                sb.append("*");
            sb.append("\n");
        }
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        triangleLB(n, sb);
        triangleLU(n, sb);
        triangleRU(n, sb);
        trianlgeRB(n, sb);

        System.out.print(sb.toString());

    }
}
