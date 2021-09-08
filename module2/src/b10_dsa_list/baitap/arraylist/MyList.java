package b10_dsa_list.baitap.arraylist;

import java.util.Arrays;

public class MyList<E> {
    /**
     * số lượng phần tử có trong MyList
     */
    private int size = 0;
    /**
     * sức chứa mặc định của MyList
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Mảng chứa các phần tử
     */
    Object elements[];

    /**
     * Sức chứa mặc định khi khởi tạo contrustor ko có tham số
     */
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * contrustor với size được truyền vào
     */
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    /**
     * Phương thức add 1 phần tử tại 1 vị trí chỉ định
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(10);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Phương thức xóa 1 index khỏi MyList
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    /**
     * phương thức trả về số lượng phần tử
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * phương thức tạo ra 1 bản sao của ArrayList hiện tại
     *
     * @return
     */
    public MyList<E> clone() {
        MyList<E> myList = new MyList<>();
        myList.elements = Arrays.copyOf(this.elements, this.size);
        myList.size = this.size;
        return myList;
    }

    /**
     * phương thức kiểm tra index có tồn tại trong mảng không
     *
     * @param o
     * @return
     */
    public boolean contains(E o) {
        return this.indexOf(o) >= 0;
    }

    /**
     * phương thức lấy index của 1 phần tử
     *
     * @param o
     * @return
     */
    public int indexOf(E o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(o)) {
                return i;
            }
        }
        return index;
    }

    /**
     * phương thức add 1 phần tử vào MyList
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (elements.length == size) {
            this.ensureCapacity(10);
        }
        elements[size] = e;
        size++;
        return true;
    }

    /**
     * phương thức tăng kích thước của MyList
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    /**
     * Phương thức lấy 1 element tại vị trí i
     *
     * @param i
     * @return
     */
    public E get(int i) {
        return (E) elements[i];
    }

    /**
     * phương thức clear ArrayList
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
}
