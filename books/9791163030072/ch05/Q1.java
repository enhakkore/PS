public class App
{
    static int factorial(int n) {

        int result = 1;

        for(int i = n ; i > 0 ; i--){
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {

        for(int i = 0 ; i <= 10 ; i++){
            System.out.println(i+"! : " + factorial(i));
        }
    }
}
