public class IntQueue {
    private int max;
    private int num;
    private int front;
    private int rear;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int enqueue(int x) {
        if(num >= max)
            throw new OverflowIntQueueException();

        num++;
        que[rear++] = x;
        if(rear == max) rear = 0;
        return x;
    }

    public int dequeue() {
        if(num <= 0)
            throw new EmptyIntQueueException();

        num--;
        int value = que[front++];
        if(front == max) front = 0;
        return value;
    }

    public int peek() {
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x) {
        for(int i = 0 ; i < num ; i++){
            int idx = (i + front) % max;
            if(que[idx] == x)
                return idx;
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
                System.out.println(que[(i+front)%max]);
        }
    }

    public int search(int x) {
        for (int i = 0; i < num; i++) {
            if(que[(i+front) % max] == x)
                return i+1;
        }
        return -1;
    }
}
