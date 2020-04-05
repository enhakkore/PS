class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
		int b = 0;
		char pivot = 'x'; //just init
		for(Character c : s.toCharArray()) {
			if(b == 0) {
				pivot = c;
			}
			if(c == pivot) {
				b++;
			} else {
				b--;
			}
			if(b == 0) {
				ans++;
			}
		}
		return ans;
    }
}
