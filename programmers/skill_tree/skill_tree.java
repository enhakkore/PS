class Solution {
    public boolean check(String skill, String tree){
        boolean result = true;
        int[] tmp = new int[skill.length()];

        tmp[0] = tree.indexOf(skill.charAt(0));
        for(int i = 1 ; i < skill.length() ; i++){
            tmp[i] = tree.indexOf(skill.charAt(i));
            if(tmp[i] != -1)
                if(tmp[i-1] == -1 || tmp[i-1] > tmp[i]){
                    result = false;
                    break;
                }
        }

        return result;
    }

    public boolean check1(String skill, String tree) {
        boolean result = true;

        if(skill.indexOf(tree.replaceAll("[^"+skill+"]", "")) != 0)
            result = false;

        return result;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String subject : skill_trees){
            if(check1(skill, subject)) answer++;
        }

        return answer;
    }
}
