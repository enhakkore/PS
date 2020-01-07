class Solution {

    public long cal(double w, double h, double x) {
        return (long)(-h / w * x + h);
    }

	public long solution(int w,int h) {
		long answer = 0;

        for(int i = 1; i <= w ; i++) {
            answer += cal(w, h, i);
        }

        return answer*2;
	}
}
