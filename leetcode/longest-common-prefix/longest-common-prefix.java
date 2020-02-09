class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        int min_leng = Integer.MAX_VALUE;
        for(String tmp : strs){
            min_leng = Math.min(min_leng, tmp.length());
        }

        if(min_leng == 0){
            return "";
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i < min_leng ; i++){
            char stand = strs[0].charAt(i);
            boolean flag = true;
            for(String tmp : strs){
                if(tmp.charAt(i) != stand){
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer.append(stand);
            } else break;
        }

        return answer.toString();
    }
}
