class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] info = new int[26];
        for(char t : text.toCharArray()){
            info[t-'a']++;
        }

        info['l'-'a'] /= 2;
        info['o'-'a'] /= 2;

        String tmp = "banlo";
        int min = Integer.MAX_VALUE;
        for(char t : tmp.toCharArray()){
            min = Math.min(info[t-'a'], min);
        }

        return min;
    }
}
