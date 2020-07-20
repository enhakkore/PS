class Solution {
    public String addBinary(String a, String b) {
        StringBuilder aString = new StringBuilder(a);
        StringBuilder bString = new StringBuilder(b);

        aString = aString.reverse();
        bString = bString.reverse();

        StringBuilder ans = new StringBuilder();

        int index = 0;
        int remainder = 0;

        while(index < aString.length() || index < bString.length()){
            int acur = 0;
            int bcur = 0;

            if(index < aString.length()){
                acur = aString.charAt(index)-'0';
            }

            if(index < bString.length()){
                bcur = bString.charAt(index)-'0';
            }

            int sum = acur+bcur+remainder;
            remainder = sum / 2;
            ans.append(sum % 2);

            index++;
        }

        if(remainder == 1) ans.append(remainder);

        return ans.reverse().toString();
    }
}
