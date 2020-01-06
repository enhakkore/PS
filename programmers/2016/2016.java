class Solution {
    static int[][] mdays = {
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };

    static String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

    public int isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

  public String solution(int a, int b) {
      int leap = isLeap(2016);

      for(int m = 0 ; m < a-1 ; m++)
          b += mdays[leap][m];

      return day[b%7];
  }
}
