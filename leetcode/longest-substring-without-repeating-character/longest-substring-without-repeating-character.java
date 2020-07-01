class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();

        int max = 0;

        for(int i = 0 ; i < arr.length ; i++){
            Set<Character> stock = new HashSet<>();

            int j;
            for(j = i ; j < arr.length ; j++){
                if(!stock.add(arr[j])) break;
            }

            max = Math.max(j-i, max);
        }

        return max;
    }
}
