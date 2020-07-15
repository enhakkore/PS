// 출처 : https://leetcode.com/problems/angle-between-hands-of-a-clock/discuss/735353/JAVAC%2B%2B-or-4-line-Mathematical-solution-with-explanation

class Solution {
    public double angleClock(int hour, int minutes) {
        double hourDegree = hour * 30 % 360 + minutes * 0.5;
        double minuteDegree = minutes * 6;

        double answer = Math.abs(minuteDegree - hourDegree);

        return Math.min(answer, 360 -answer);
    }
}
