public class IntStack {
    private int max;
    private int ptr, ptrR;
    private int[] stk;

    public class EmptyIntStacKException extends RuntimeException {
        public EmptyIntStacKException(){
            System.out.println("스택이 비어있습니다.");
        };
    }

    public class OverFlowIntStackException extends RuntimeException {
        public OverFlowIntStackException(){
            System.out.println("스택이 가득찼습니다.");
        };
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = ptrR = capacity;

        try {
            stk = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(int x) throws OverFlowIntStackException {
        return pushToLeft(x);
    }

    public int pushToLeft(int x) {
        if( ptr >= ptrR)
            throw new OverFlowIntStackException();
        return stk[ptr++] = x;
    }

    public int pushToRight(int x) {
        if (ptrR <= ptr)
            throw new OverFlowIntStackException();
        return stk[--ptrR];
    }

    public int pop() throws EmptyIntStacKException {
        return popOfLeft();
    }

    public int popOfLeft() throws EmptyIntStacKException {
        if(ptr <= 0)
            throw new EmptyIntStacKException();
        return stk[--ptr];
    }

    public int popOfRight() throws EmptyIntStacKException {
        if(ptrR >= max)
            throw new EmptyIntStacKException();
        return stk[ptrR++];
    }

    public int peek() throws EmptyIntStacKException {
        return peekForLeft();
    }

    public int peekForLeft() throws EmptyIntStacKException {
        if(ptr <= 0)
            throw new EmptyIntStacKException();
        return stk[ptr-1];
    }

    public int peekForRight() throws EmptyIntStacKException {
        if(ptrR >= max)
            throw new EmptyIntStacKException();
        return stk[ptrR+1];
    }

    public int indexOf(int x) {
        return indexOfLeft(x);
    }

    public int indexOfLeft(int x) {
        for(int i = ptr - 1; i >= 0 ; i--){
            if(stk[i] == x)
                return i;
        }
        return -1;
    }

    public int indexOfRight(int x){
        for(int i = ptrR + 1; i > max ; i++){
            if(stk[i] == x )
                return i;
        }
        return -1;
    }

    public void clearLeft() {
        ptr = 0;
    }

    public void clearRight() {
        ptrR = max;
    }

    public int sizeOfLeft() {
        return ptr;
    }

    public int sizeOfRight() {
        return max - ptrR;
    }

    public int capacity() {
        return max;
    }

    public boolean isLeftEmpty() {
        return ptr <= 0;
    }

    public boolean isRightEmpty() {
        return ptrR >= max;
    }

    public boolean isFull() {
        return ptr >= ptrR;
    }

    public void dumpLeft() {
        if(ptr <= 0)
            throw new EmptyIntStacKException();
        else
            for(int i = 0 ; i < ptr ; i++){
                System.out.println(stk[i]);
            }
    }

    public void dumpRight() {
        if(ptrR >= max)
            throw new EmptyIntStacKException();
        else
            for (int i = max - 1; i > ptrR ; i--){
                System.out.println(stk[i]);
            }
    }
}
