class Solution {
  public int solution(int n) {
      int[] prime = new int[500000];
      int answer = 0;
      prime[answer++] = 2;

      for(int i = 3; i <= n ; i++){
          boolean flag = true;
          for(int j = 0 ; prime[j]*prime[j] <= i ; j++){
              if( i % prime[j] == 0){
                  flag = false;
                  break;
              }
          }
          if(flag) prime[answer++] = i;
      }

      return answer;
  }
}
