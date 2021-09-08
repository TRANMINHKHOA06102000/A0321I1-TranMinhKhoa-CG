package b10_dsa_list.baitap.arraylist;

public class MyListTest {
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

        //Test phương thức add 1 phần tử vào MyList
        Student student1 = new Student(1, "Khoa");
        Student student2 = new Student(2, "Minh");
        Student student3 = new Student(3, "Huệ");
        Student student4 = new Student(4, "Ly");
        Student student5 = new Student(5, "Long");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);
        studentMyList.add(student5);


        //Test Phương thức add 1 phần tử tại 1 vị trí chỉ định
        Student student6 = new Student(6, "Trúc");
        studentMyList.add(3, student6);

        //Test phương thức lấy index của 1 phần tử
        System.out.println(studentMyList.indexOf(student3));

        //Test Phương thức get (lấy 1 element tại vị trí i)
        System.out.println(studentMyList.get(1).getName());

        //Test phương thức kiểm tra index có tồn tại trong mảng không
        System.out.println(studentMyList.contains(student4));

        //Test Phương thức size
        studentMyList.size();
        System.out.println(studentMyList.size());

        //Phương thức xóa 1 index khỏi MyList
        studentMyList.remove(1);

        // dùng vòng for để duyệt mảng và in ra màn hình
        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }

        //Test phương thức tạo ra 1 bản sao của ArrayList hiện tại
        MyList<Student> newMyList = new MyList<>();
        newMyList = studentMyList.clone();
        for (int i = 0; i < newMyList.size(); i++) {
            System.out.println(newMyList.get(i).getName());
        }

        //Test phương thức clear
        studentMyList.clear();
    }
}
