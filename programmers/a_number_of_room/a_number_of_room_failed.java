import java.util.*;

class Solution {
    static int[][] arrowNum = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static HashMap<Integer, ArrayList<Integer>> visitedNode = new HashMap<>();
    static int aNumberOfRoom = 0;

    public int solution(int[] arrows) {
        int[] currentNode = new int[2];
        int[] beforeNode = new int[2];
        int[] goingToNode = new int[2];

        visitedNode.put(currentNode[0], new ArrayList<>(Arrays.asList(currentNode[1])));

        for(int arrow : arrows){
            System.out.println(currentNode[0]+" "+currentNode[1]);
            goingToNode[0] = currentNode[0] + arrowNum[arrow][0];
            goingToNode[1] = currentNode[1] + arrowNum[arrow][1];

            if(visitedNode.containsKey(goingToNode[0])){
                ArrayList<Integer> tmpR = visitedNode.get(goingToNode[0]);
                if(tmpR.contains(goingToNode[1])){
                    if(goingToNode[0] != beforeNode[0] || goingToNode[1] != beforeNode[1]){
                        aNumberOfRoom++;
                        System.out.println(">> Add Room!!");
                    }
                } else {
                    tmpR.add(goingToNode[1]);
                }
            } else {
                visitedNode.put(goingToNode[0], new ArrayList<>(Arrays.asList(goingToNode[1])));
            }

            beforeNode[0] = currentNode[0];
            beforeNode[1] = currentNode[1];
            currentNode[0] = goingToNode[0];
            currentNode[1] = goingToNode[1];
        }

        return aNumberOfRoom;
    }
}
