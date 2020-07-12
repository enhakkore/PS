class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bFreq = new int[26];
        for(int i = 0 ; i < B.length ; i++){
            int[] freq = new int[26];
            for(char c : B[i].toCharArray()){
                freq[c-'a']++;
            }

            for(int j = 0 ; j < 26 ; j++)
                bFreq[j] = Math.max(bFreq[j], freq[j]);
        }

        List<String> ans = new ArrayList<>();
        for(String a : A){
            int[] temp = Arrays.copyOf(bFreq, 26);

            for(char c : a.toCharArray()){
                temp[c-'a']--;
            }

            boolean result = false;
            for(int n : temp)
                if(n > 0){
                    result = true;
                    break;
                }

            if(!result) ans.add(a);
        }

        return ans;
    }
}
