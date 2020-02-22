class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        List<String> stock = new LinkedList<>();
        String[] sen = sentence.split(" ");

        for(String tmp : sen){
            boolean flag = true;
            for(String root : dict){
                if(tmp.startsWith(root)){
                    stock.add(root);
                    flag = false;
                    break;
                }
            }
            if(flag) stock.add(tmp);
        }

        String ans = String.join(" ", stock);
        return ans;
    }
}
