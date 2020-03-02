class Solution {
    static int[] A = {1,2,4,8};
    static char[] B = {'a','b','c','d','e','f'};

    public String toHex(int num) {
        String ans;

        ans = num > 0
            ? toGetAns(toBinary((long)num))
            : toGetAns(change(toBinary(Math.abs((long)num))));

        int index = 0;
        while(index < ans.length()-1 && ans.charAt(index)=='0'){
            index++;
        }

        return ans.substring(index);
    }

    public ArrayDeque<Integer> toBinary(long num){
        ArrayDeque<Integer> info = new ArrayDeque<>();
        while(num > 0){
            info.push((int)(num % 2));
            num /= 2;
        }

        while(info.size() < 32){
            info.push(0);
        }

        return info;
    }

    public ArrayDeque<Integer> change(ArrayDeque<Integer> info){
        ArrayDeque<Integer> info2 = new ArrayDeque<>();

        int carry = 1;
        while(!info.isEmpty()){
            int tmp = info.removeLast();
            tmp = tmp == 0 ? 1 : 0;
            tmp += carry;
            if(tmp == 2){
                tmp = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            info2.push(tmp);
        }

        return info2;
    }

    public String toGetAns(ArrayDeque<Integer> info){
        StringBuilder sb = new StringBuilder();

        while(!info.isEmpty()){
            int value = 0;
            for(int i = 3 ; i > -1 ; i--){
                value += info.removeFirst()*A[i];
            }
            if(value > 9)
                sb.append(B[value-10]);
            else sb.append(value);
        }

        return sb.toString();
    }
}
