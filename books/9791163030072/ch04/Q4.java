public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public IntAryQueue(int capacity){
        max = capacity;
        try{
            que = new int[capacity];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException(){}
    }

    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException(){}
    }

    public int enqueue(int x) {
        if(num >= max)
            throw new OverflowIntAryQueueException();
        return que[num++] = x;
    }

    public int dequeue() {
        if(num <= 0)
            throw new EmptyIntAryQueueException();

        int value = que[0];
        for(int i =  0; i < num - 1 ; i++){
            que[i] = que[i+1];
        }
        num--;
        return que[0];
    }

    public int peek() {
        if(num <= 0)
            throw new EmptyIntAryQueueException();
        return que[0];
    }

    public int indexOf(int x) {
        for(int i = 0 ; i < num ; i++){
            if(que[i] == x)
                return i;
        }
        return -1;
    }

    public void clear() {
        num = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if(num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for(int i = 0 ; i < num ; i++)
                System.out.println(que[i]);
        }
    }
}
