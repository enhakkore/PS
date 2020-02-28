class Solution {
    public int maximum69Number (int num) {
        TreeSet<Integer> info = new TreeSet<>();
        info.add(num);

        char[] tmp2 = String.valueOf(num).toCharArray();

        for(int i = 0 ; i < tmp2.length ; i++){
            char origin = tmp2[i];
            tmp2[i] = origin == '6' ? '9' : '6' ;
            info.add(Integer.parseInt(new String(tmp2)));
            tmp2[i] = origin;
        }

        return info.last().intValue();
    }
}
