import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   // Complete the checkMagazine function below.
   static void checkMagazine(String[] magazine, String[] note) {
       if(note.length > magazine.length) {
           System.out.println("No");
           return;
       }

       HashMap<String, Integer> stock = new HashMap<>();
       Arrays.stream(magazine).forEach(word ->
           stock.put(word, stock.getOrDefault(word, 0)+1)
       );


       for(String note_word : note){
           int value = stock.getOrDefault(note_word, 0);
           if(value == 0){
               System.out.print("No");
               return;
           } else {
               value--;
               stock.put(note_word, value);
           }
       }

       System.out.print("Yes");
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
       String[] mn = scanner.nextLine().split(" ");

       int m = Integer.parseInt(mn[0]);

       int n = Integer.parseInt(mn[1]);

       String[] magazine = new String[m];

       String[] magazineItems = scanner.nextLine().split(" ");
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for (int i = 0; i < m; i++) {
           String magazineItem = magazineItems[i];
           magazine[i] = magazineItem;
       }

       String[] note = new String[n];

       String[] noteItems = scanner.nextLine().split(" ");
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for (int i = 0; i < n; i++) {
           String noteItem = noteItems[i];
           note[i] = noteItem;
       }

       checkMagazine(magazine, note);

       scanner.close();
   }
}
