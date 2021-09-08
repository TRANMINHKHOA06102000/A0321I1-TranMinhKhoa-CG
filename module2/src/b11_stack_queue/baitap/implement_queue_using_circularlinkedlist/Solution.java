package b11_stack_queue.baitap.implement_queue_using_circularlinkedlist;

public class Solution {
    private Node front;
    private Node rear;

    public Solution() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int value) {
        Node temp = new Node(value);
        if (this.front == null) {
            this.front = this.rear = temp;
            this.front.link = rear;
            this.rear.link = front;
        } else {
            this.rear.link = temp;
            this.rear = temp;
            this.rear.link = this.front;
        }
    }

    public Node deQueue() {
        if (front == null) {
            return null;
        } else if (front == rear) {
            Node temp = front;
            front = rear = null;
            return temp;
        } else {
            Node temp = front;
            front = front.link;
            rear.link = front;
            return temp;
        }
    }

    public void displayQueue() {
        Node temp = front;
        if (front == null) {
            System.out.println("null");
        } else {
            while (temp.link != front) {
                System.out.println(temp.data);
                temp = temp.link;
            }
            System.out.println(rear.data);
        }
    }
}
