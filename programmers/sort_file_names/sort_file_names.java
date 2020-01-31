import java.util.*;

class Solution {
    public String head(String file){
        int index;
        for(index = 0; index < file.length() ; index++){
            if(file.charAt(index) >= '0' && file.charAt(index) <= '9')
                break;
        }

        return file.substring(0, index);
    }

    public String number(String file, int start) {
        int index;
        for(index = start ; index < file.length() ; index++){
            if(file.charAt(index) < '0' || file.charAt(index) > '9')
                break;
        }

        return file.substring(start, index);
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String f1_head = head(f1).toLowerCase();
            String f2_head = head(f2).toLowerCase();

            int compareValue = f1_head.compareTo(f2_head);

            if(compareValue == 0){
                String f1_number = number(f1, f1_head.length());
                String f2_number = number(f2, f2_head.length());
                int f1_num = Integer.parseInt(f1_number);
                int f2_num = Integer.parseInt(f2_number);

                return f1_num - f2_num;
            } else
                return compareValue;
        });

        return files;
    }
}
