class Solution {
    public String sortString(String s) {
        List<Character> stock = s.chars().sorted().mapToObj(c -> Character.valueOf((char)c)).collect(Collectors.toList());
        stock = new LinkedList<>(stock);

        StringBuilder sb = new StringBuilder();

        while(!stock.isEmpty()) {

            char base = stock.get(0).charValue();
            sb.append(base);
            stock.remove(0);

            if(stock.isEmpty()) break;

            List<Character> dump = new ArrayList<>();
            for(int i = 0 ; i < stock.size() ; i++){
                char cur = stock.get(i).charValue();
                if(cur > base){
                    dump.add(stock.get(i));
                    sb.append(stock.get(i));
                    base = stock.get(i).charValue();
                }
            }

            for(Character d : dump){
                stock.remove(d);
            }

            if(stock.isEmpty()) break;

            base = stock.get(stock.size()-1).charValue();
            sb.append(base);
            stock.remove(stock.size()-1);

            if(stock.isEmpty()) break;

            dump = new ArrayList<>();
            for(int i = stock.size()-1 ; i >= 0 ; i--){
                char cur = stock.get(i).charValue();
                if(cur < base){
                    sb.append(stock.get(i));
                    dump.add(stock.get(i));
                    base = stock.get(i).charValue();
                }
            }

            for(Character d : dump){
                stock.remove(d);
            }
        }

        return sb.toString();
    }
}
