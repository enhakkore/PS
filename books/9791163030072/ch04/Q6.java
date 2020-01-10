public class Gqueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){}
    }

    public static class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public Gqueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = (E[])new Object[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public E enqueue(E x) {
        if(num >= max)
            throw new OverflowIntQueueException();

        num++;
        que[rear++] = x;
        if(rear == max) rear = 0;
        return x;
    }

    public E dequeue() {
        if(num <= 0)
            throw new EmptyIntQueueException();

        num--;
        E value = que[front++];
        if(front == max) front = 0;
        return value;
    }

    public E peek() {
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(E x) {
        for(int i = 0 ; i < num ; i++){
            int idx = (i + front) % max;
            if(que[idx].equals(x))
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
            if(que[(i+front) % max].equals(x))
                return i+1;
        }
        return -1;
    }
}
