class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();

        for(int num = left ; num <= right ; num++){
            if(check(num)) ans.add(num);
        }

        return ans;
    }

    public boolean check(int num){
        boolean result = true;
        int rep = num;

        while(rep > 0){
            int cur = rep % 10;

            if( cur == 0 || num % cur != 0){
                result = false;
                break;
            }

            rep /= 10;
        }

        return result;
    }
}
