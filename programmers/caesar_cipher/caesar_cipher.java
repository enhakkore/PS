// 출처 : https://jhnyang.tistory.com/188

class Solution {
    public String solution(String s, int n) {
        return s.chars().map( c -> {
            if( c >= 'a' && c <= 'z')
                return 'a' + (c - 'a' + n) % 26;
            else if(c >= 'A' && c <= 'Z')
                return 'A' + (c - 'A' + n) % 26;
            else
                return c;
        }).mapToObj( c -> String.valueOf((char)c))
        .reduce( (a, b) -> a+b ).orElse("");
    }
}
