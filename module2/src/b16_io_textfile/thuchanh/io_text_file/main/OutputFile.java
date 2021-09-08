package b16_io_textfile.thuchanh.io_text_file.main;

import b16_io_textfile.thuchanh.io_text_file.common.FileUtils;
import b16_io_textfile.thuchanh.io_text_file.model.Student;

import java.util.ArrayList;
import java.util.List;

public class OutputFile {
    public static final String FILE_NAME = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\b16_io_textfile\\thuchanh\\io_text_file\\data\\student.csv";
    public static final String COMMAN = ",";

    public static void main(String[] args) {
        Student student1 = new Student(1, "Trần Minh Khoa", "06/10/2000");
        Student student2 = new Student(2, "Võ Thành Luân", "17/01/2000");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        String line = null;
        for (Student student : studentList) {
            line = student.getId() + COMMAN + student.getName() + COMMAN + student.getDateOfBirth();
            FileUtils.writeFile(FILE_NAME, line);
        }
    }
}
