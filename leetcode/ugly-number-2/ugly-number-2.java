// source from https://www.programcreek.com/2014/05/leetcode-ugly-number-ii-java/

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyStock = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        uglyStock.add(1);

        while(uglyStock.size() < n){
            int m2 = uglyStock.get(i)*2;
            int m3 = uglyStock.get(j)*3;
            int m5 = uglyStock.get(k)*5;

            int min = Math.min(m2, Math.min(m3, m5));
            uglyStock.add(min);

            if(m2 == min) i++;
            if(m3 == min) j++;
            if(m5 == min) k++;
        }

        return uglyStock.get(uglyStock.size()-1);
    }
}
