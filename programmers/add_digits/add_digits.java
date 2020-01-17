public class Solution {
    public int solution(int n) {
        return (int)String.valueOf(n).chars().map( c -> c -= '0').sum();
    }
}
