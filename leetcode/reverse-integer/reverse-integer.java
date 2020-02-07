class Solution {
    public int reverse(int x) {
        String tmp = Integer.toString(x);
        StringBuilder sb = new StringBuilder(tmp);
        String tmp1 = sb.reverse().toString();

        if(tmp1.charAt(tmp1.length()-1) == '-'){
            StringBuilder sb2 = new StringBuilder();
            sb2.append('-');
            sb2.append(tmp1.substring(0, tmp1.length()-1));
            tmp1 = sb2.toString();
        }

        int ans;
        try{
            ans = Integer.parseInt(tmp1);
        } catch(Exception e){
            ans = 0;
        }

        return ans;
    }
}
