class Solution {
    public String freqAlphabets(String s) {
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();

        int index = 0;
        while(index < arr.length){
            int check = index+2;

            if(check < arr.length && arr[check] == '#'){
                int tmp = Integer.parseInt(s.substring(index, check));
                char target = (char)(tmp-1+'a');
                ans.append(target);
                index = check+1;
            } else {
                char target = (char)(arr[index]+48);
                ans.append(target);
                index += 1;
            }
        }

        return ans.toString();
    }
}
