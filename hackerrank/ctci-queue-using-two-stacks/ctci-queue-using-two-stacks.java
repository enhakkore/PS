import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {
    private ArrayDeque<T> A, B;
    private T frontValue;

    MyQueue(){
        A = new ArrayDeque<T>();
        B = new ArrayDeque<T>();
    }

    public void enqueue(T value){
        A.push(value);
    }

    public T dequeue(){
        preWork();
        return B.pop();
    }

    public T peek(){
        preWork();
        return B.peek();
    }

    public void preWork(){
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
    }
}
