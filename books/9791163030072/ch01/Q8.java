import java.util.Scanner;

public class App
{

    public static int gaussSum(int n){
        if( n <= 0) return 0;
        return ((1+n)*n)/2;
    }
    
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.print("1부터 "+n+"까지의 합 : "+gaussSum(n));
    }
}
