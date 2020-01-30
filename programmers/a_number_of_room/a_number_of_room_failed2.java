import java.util.*;

class Solution {
    static int[][] arrowNum = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public class Vertex{
        int r, c;
        public Vertex(int r, int c){
            this.r = r;
            this.c = c;
        }

        public int getR() { return r;}
        public int getC() { return c;}
    }

    public class Edge{
        Vertex one, two;
        public Edge(Vertex one, Vertex two){
            this.one = one;
            this.two = two;
        }

        public Vertex getOne(){ return one;}
        public Vertex getTwo(){ return two;}
    }

    public int solution(int[] arrows) {
        ArrayList<Vertex> vList = new ArrayList<>();
        ArrayList<Edge> eList = new ArrayList<>();

        int[] currentNode = new int[2];
        Vertex currentVertex = new Vertex(0, 0);
        Vertex beforeVertex;

        vList.add(currentVertex);
        beforeVertex = currentVertex;

        for(int arrow : arrows){
            currentNode[0] += arrowNum[arrow][0];
            currentNode[1] += arrowNum[arrow][1];

            boolean isThereNode = false;
            for(Vertex tmpV: vList){
                if(tmpV.getR() == currentNode[0] && tmpV.getC() == currentNode[1]){
                    isThereNode = true;
                    currentVertex = tmpV;
                    break;
                }
            }
            if(!isThereNode){
                currentVertex = new Vertex(currentNode[0], currentNode[1]);
                vList.add(currentVertex);
            }

            boolean isThereEdge = false;
            for(Edge tmpE : eList){
                if(tmpE.getOne().getR() == currentVertex.getR() && tmpE.getOne().getC() == currentVertex.getC())
                    if(tmpE.getTwo().getR() == beforeVertex.getR() && tmpE.getTwo().getC() == beforeVertex.getC()){
                        isThereEdge = true;
                        break;
                    }

                if(tmpE.getTwo().getR() == currentVertex.getR() && tmpE.getTwo().getC() == currentVertex.getC())
                    if(tmpE.getOne().getR() == beforeVertex.getR() && tmpE.getOne().getC() == beforeVertex.getC()){
                        isThereEdge = true;
                        break;
                    }
            }
            if(!isThereEdge){
                eList.add(new Edge(currentVertex, beforeVertex));
            }

            beforeVertex = currentVertex;
        }
        System.out.println(vList.size() + " " + eList.size());

        return 1-vList.size()+eList.size();
    }
}
