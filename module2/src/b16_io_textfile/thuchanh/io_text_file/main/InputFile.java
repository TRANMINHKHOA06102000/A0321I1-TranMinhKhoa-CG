package b16_io_textfile.thuchanh.io_text_file.main;

import b16_io_textfile.thuchanh.io_text_file.common.FileUtils;
import b16_io_textfile.thuchanh.io_text_file.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class InputFile {
    public static final String FILE_NAME = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\b16_io_textfile\\thuchanh\\io_text_file\\data\\student.csv";
    public static final String COMMAN = ",";

    public static void main(String[] args) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] student = line.split(COMMAN);
                System.out.println(student[0] + COMMAN + student[1] + COMMAN + student[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
