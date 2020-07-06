class MinStack {
    int[] stock;
    int size;
    int top;
    int minVal;
    boolean statusForMin;

    /** initialize your data structure here. */
    public MinStack() {
        size = 100;
        stock = new int[100];
        top = -1;
        minVal = 0;
        statusForMin = false;
    }

    public void push(int x) {
        if(top == size-1) sizeUp();

        stock[++top] = x;
        statusForMin = true;
    }

    public void pop() {
        if(top < 0) return;
        statusForMin = true;
        top--;
    }

    public Integer top() {
        if(top < 0) return null;
        return stock[top];
    }

    public Integer getMin() {
        if(!statusForMin){
            if(top < 0) return null;
            return minVal;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i <= top ; i++){
            min = Math.min(min, stock[i]);
        }

        minVal = min;
        statusForMin = false;
        return minVal;
    }

    public void sizeUp() {
        size *= 2;
        int[] stock2 = new int[size];

        for(int i = 0; i < stock.length ; i++){
            stock2[i] = stock[i];
        }

        stock = stock2;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
