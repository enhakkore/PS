import java.util.*;
import java.util.stream.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n).mapToObj(num -> {
            String result = "";
            if(num % 3 == 0 || num % 5 == 0){
                if(num % 3 == 0) result += "Fizz";
                if(num % 5 == 0) result += "Buzz";
            } else result += num;
            return result;
        }).collect(Collectors.toList());
    }
}
