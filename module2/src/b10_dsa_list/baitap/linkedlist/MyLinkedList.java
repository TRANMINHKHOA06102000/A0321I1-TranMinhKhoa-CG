package b10_dsa_list.baitap.linkedlist;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    //Phần tử đầu tiên của danh sách liên kết
    private Node head;
    //Số lượng phần tử trong danh sách
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        //khai báo 1 biến là temp trỏ đến giá trị head
        Node temp = head;
        //khai báo 1 node là holder
        Node holder;
        //cho con trỏ chạy tới vị trí index-1
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        //cho holder tham chiếu đến vị trí index
        holder = temp.next;
        //Node tại vị trí index-1 sẽ trỏ tới node mới
        temp.next = new Node(element);
        //node mới sẽ trẻ đến holder
        temp.next.next = holder;
        //tăng số lượng danh sách lên 1
        numNodes++;
    }

    public void addFirst(E e) {
        //khai báo 1 biến là temp trỏ đến giá trị head
        Node temp = head;
        //Biến head sẽ nhận giá trị là 1 Node mới
        head = new Node(e);
        //head.next trỏ đến temp
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        //khai báo 1 biến là temp trỏ đến giá trị head
        Node temp = head;
        //sẽ cho con trỏ chạy đến phần tử cuối cùng của danh sách
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        //khai báo biến temp trỏ đến head
        Node temp = head;
        Object data;
        //Nếu index =0 thì trả về data hiện tại
        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public boolean remove(Object e) {
        //remove đối tượng nếu element head
        if (head.data.equals(e)) {
            remove(0);
            return true;
        } else {
            //khai báo 1 node temp trỏ đến head
            Node temp = head;
            while (temp.next != null) {
                //nếu như tồn tại 1 phần tử có data bằng data truyền vào thì node đó sẽ bị remove
                if (temp.next.data.equals(e)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        //kiểm tra linkedlist có phần tử hay không
        if (numNodes == 0) {
            throw new NullPointerException("LinkedList này null");
        }
        //khai báo linkedlist trả về
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        //Khai báo 1 temp trỏ đến head
        Node temp = head;
        //add temp vào danh sách trả về để nó làm head
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean contains(E o) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e){
        this.addLast(e);
        return true;
    }


    /**
     * Phương thức add(E e): boolean và ensureCapacity(int minCapacity): void ==> bị dư trong LinkedList
     */

    public E get(int index) {
        //khai báo biến temp trỏ tới head
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            return (E) temp.data;
        }
    }

    public E getLast() {
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes - 1; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

}
