class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        char base = 'a';
        int tn = n;
        while(sb.length() != n){
            if(tn % 2 == 0){
                sb.append(base);
                base = (char)(base+1);
                tn--;
            }
            sb.append(base);
        }

        return sb.toString();
    }
}
