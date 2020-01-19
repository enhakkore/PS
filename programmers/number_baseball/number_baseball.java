// 출처 : https://chaibin0.tistory.com/entry/%EC%88%AB%EC%9E%90-%EC%95%BC%EA%B5%AC

class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;

        for(int num = 123 ; num <= 987 ; num++){
            int tmp[] = String.valueOf(num).chars().map(c -> c -= '0').toArray();

            if(tmp[0] == tmp[1] || tmp[1] == tmp[2] || tmp[0] == tmp[2])
                continue;
            if(tmp[0] == 0 || tmp[1] == 0 || tmp[2] == 0 )
                continue;

            boolean flag = true;
            for(int[] base : baseball){
                int strike = 0, ball = 0;
                int[] base_tmp = String.valueOf(base[0]).chars().map(c -> c -= '0').toArray();

                for(int a = 0 ; a < 3 ; a++){
                    for(int b = 0 ; b < 3 ; b++){
                        if( a == b && tmp[a] == base_tmp[b])
                            strike++;
                        else if( a != b && tmp[a] == base_tmp[b])
                            ball++;
                    }
                }

                if( base[1] != strike || base[2] != ball){
                    flag = false;
                    break;
                }
            }

            if(flag) answer++;
        }
        return answer;
    }
}
