package b10_dsa_list.baitap.linkedlist;

public class MyLinkedListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Khoa");
        Student student2 = new Student(2, "Minh");
        Student student3 = new Student(3, "Huệ");
        Student student4 = new Student(4, "Ly");
        Student student5 = new Student(5, "Long");
        Student student6 = new Student(6, "Nguyệt");

        //test các phương thức add
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student1);
        myLinkedList.addLast(student4);
        myLinkedList.addLast(student5);
        myLinkedList.add(2, student3);

        //in ra màn hình
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }

        //test phương thức remove
        myLinkedList.remove(2);
        myLinkedList.remove(student4);

        System.out.println("-------------------------------------");
        //test phương thức contains
        System.out.println(myLinkedList.contains(student1));
        System.out.println(myLinkedList.contains(student6));

        System.out.println("-------------------------------------");
        //test phương thức indexOf
        System.out.println(myLinkedList.indexOf(student2));

        System.out.println("-------------------------------------");
        //Test phương thức clone
        MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();

        for (int i = 0; i < cloneLinkedList.size(); i++) {
            Student student = (Student) cloneLinkedList.get(i);
            System.out.println(student.getName());
        }
        System.out.println("-----------------------------------------");
        //Test phương thức get
        System.out.println(myLinkedList.getFirst().getName());
        System.out.println(myLinkedList.getLast().getName());

        //test phương thức clear
        myLinkedList.clear();
    }
}
