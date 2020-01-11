public class App
{
    static int gcd(int x, int y) {
        while(true){
            if(y == 0)
                return x;
            int tmp = y;
            y = x % y;
            x = tmp;
        }
    }

    public static void main(String[] args) {

        System.out.println(gcd(8, 22));
    }
}
