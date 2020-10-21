import java.util.ArrayList;

class Solution {
    public int calPoints(String[] ops) {
        List<Integer> stock = new ArrayList<>();
        
        for(String op : ops){
            int lastIndex = stock.size() - 1;
            switch(op){
                case "C" :
                    stock.remove(lastIndex);
                    break;
                case "D" :
                    int doubleScore = stock.get(lastIndex) * 2;
                    stock.add(doubleScore);
                    break;
                case "+" :
                    int newScore = stock.get(lastIndex) + stock.get(lastIndex - 1);
                    stock.add(newScore);
                    break;
                default :
                    stock.add(Integer.parseInt(op));
            }
        }
        
        return stock.stream().mapToInt(v -> v.intValue()).sum();
    }
}

