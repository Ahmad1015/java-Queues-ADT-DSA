
public class Queue_ADT{
    public static void main(String[] args){
       Boolean flag =  Class_Assignment_2.balance("([{}])");
       System.out.println(flag);
    }
}
class Node{
    int data;
    Node next;
    public Node(){
        this.data = 0;
        this.next = null;
    }
    public Node(int value){
        this.data = value;
        this.next = null;
    }
}

class Queue_Linked{
    Node front;
    Node rear;

    public boolean enqueue(int v){
        try{
            Node temp = new Node(v);
            if(rear == null){    // Empty LinkedList
                rear = front = temp;
            }
            else if (front == rear){
                front.next = temp;
                rear = temp;
            }
            else{
                rear.next= temp;
                rear = temp;
            }
            return true;
        }
        catch (OutOfMemoryError  e){
            return false;
        }
    }
    public Node dequeue(){
        if(front == null)
            return null;
        else{
            Node temp = front;
            front = front.next;
            return temp;
        }
    }

    boolean isFull(){
        return false;
    }

    boolean isEmpty(){
        return (front==null);
    }

    public String toString(){
        Node curr = front;
        String to_Return = "";
        while(curr != null){
            to_Return = to_Return+ " "+ curr.data;
            curr = curr.next;
        }
        return to_Return;
    }

    public Node getFront(){
        return front;
    }
}
class circularQueue{
    int front;
    int rear;
    int[] arr;
    int size;
    circularQueue(){
        size = 5;
        arr = new int[size];
        front = rear = -1;
    }
    circularQueue(int size){
        this.size = size;
        arr = new int[this.size];
        front = rear = -1;
    }

    boolean enqueue(int v){
        if(isEmpty()){
            front = rear = 0;
            arr[rear] = v;
            return true;
        }
        else if (isFull()){
            return false;
        }
        else{
            rear = (rear+1) % this.size;
            arr[rear] = v;
            return true;
        }
    }
    int dequeue(){
        if(isEmpty()){
            return -1;
        }
        else if (front == rear){
            int temp = arr[front];
            rear = front = -1;
            return temp;
        }
        else{
            int temp = arr[front];
            front = (front+1) % this.size;
            return temp;
        }
    }

    boolean isFull(){
        if ((rear+1) % this.size == front){
            System.out.println("Array Size full");
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        return (front == -1 && rear == -1);
    }

    public String toString(){
        String temp = "";
        for(int i=0;i<size;i++){
            temp = temp + "" + arr[i];
        }
        return temp;
    }

    int getfront(){
        if(isEmpty()){
            return -1;
        }
        else{
            int temp = arr[front];
            return temp;
        }
    }

}