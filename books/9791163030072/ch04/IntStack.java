public class IntStack {
    private int max;
    private int ptr;
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
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(int x) throws OverFlowIntStackException {
        if(ptr >= max)
            throw new OverFlowIntStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStacKException {
        if(ptr <= 0)
            throw new EmptyIntStacKException();
        return stk[--ptr];
    }

    public int peek() throws EmptyIntStacKException {
        if(ptr <= 0)
            throw new EmptyIntStacKException();
        return stk[ptr-1];
    }

    public int indexOf(int x) {
        for(int i = ptr - 1 ; i >= 0 ; i--){
            if(stk[i] == x)
                return i;
        }

        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int size() {
        return ptr;
    }

    public int capacity() {
        return max;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if(ptr <= 0)
            throw new EmptyIntStacKException();
        else
            for(int i = 0 ; i < ptr ; i++){
                System.out.println(stk[i]);
            }
    }
}
