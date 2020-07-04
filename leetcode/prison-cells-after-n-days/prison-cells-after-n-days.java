class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        LinkedList<int[]> stock = new LinkedList<>();

        int tn = N;
        while(tn-- > 0){
            int[] cur = new int[8];

            for(int i = 1 ; i < 7 ; i++){
                if(cells[i-1] == cells[i+1])
                    cur[i] = 1;
            }

            cells = cur;

            boolean check = true;
            if(!stock.isEmpty()){
                int[] tmp = stock.get(0);

                for(int i = 0; i < 8 ; i++){
                    if(tmp[i] != cells[i]){
                        check = false;
                        break;
                    }
                }
            }

            if(!stock.isEmpty() && check) break;

            stock.add(cells);
        }

        if(stock.size() == N){
            return stock.get(stock.size()-1);
        }

        stock.addFirst(stock.remove(stock.size()-1));
        return stock.get(N % stock.size());
    }
}
