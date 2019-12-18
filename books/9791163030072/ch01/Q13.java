public class App
{
    public static void main( String[] args ) {
        StringBuilder sb = new StringBuilder();

        sb.append("  |");
        for(int i = 1; i <= 9 ; i++){
            sb.append(" "+i);
        }

        sb.append("\n--+---------------------\n");

        for(int i = 1; i <= 9 ; i++){
            sb.append(i+" |");

            for(int j = 1 ; j <= 9; j++){
                int tmp = i+j;
                sb.append(" "+tmp);
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
