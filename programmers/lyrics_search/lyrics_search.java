class Solution {
    public String startString(String querie){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < querie.length() ; i++){
            char tmp = querie.charAt(i);
            if(tmp == '?')
                break;
            else sb.append(tmp);
        }
        return sb.toString();
    }

    public String endString(String querie){
        StringBuilder sb = new StringBuilder();
        for(int i = querie.length()-1 ; i >= 0; i--){
            char tmp = querie.charAt(i);
            if(tmp == '?')
                break;
            else sb.append(tmp);
        }
        return sb.reverse().toString();
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i = 0 ; i < queries.length ; i++){
            String tmp = queries[i];
            String tmp_sub;
            boolean flag;
            if(tmp.charAt(0) == '?'){
                tmp_sub = endString(tmp);
                flag = true;
            } else {
                tmp_sub = startString(tmp);
                flag = false;
            }

            int count = 0;
            for(int j = 0; j < words.length ; j++){
                if(words[j].length() == tmp.length()){
                    if(flag && words[j].endsWith(tmp_sub))
                        count++;
                    if(!flag && words[j].startsWith(tmp_sub))
                        count++;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
