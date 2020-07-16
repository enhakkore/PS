class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = sArr.length-1 ; i >= 0 ; i--){
            if(!sArr[i].isBlank()){
                sb.append(sArr[i]);
                sb.append(" ");
            }
        }
        return sb.toString().stripTrailing();
    }
}
