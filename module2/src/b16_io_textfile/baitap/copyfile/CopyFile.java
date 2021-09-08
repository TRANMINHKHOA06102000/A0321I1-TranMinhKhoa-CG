package b16_io_textfile.baitap.copyfile;

import java.io.*;

public class CopyFile {
    public static final String FILE_TARGET = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\b16_io_textfile\\baitap\\data\\country_copy.csv";
    public static final String FILE_SOURCE = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\b16_io_textfile\\baitap\\data\\country.csv";

    public static void main(String[] args) {
        File inputFile = new File(FILE_SOURCE);
        File outputFile = new File(FILE_TARGET);
        if (!inputFile.exists() && outputFile.exists()) {
            System.out.println("Source file doesn't exist and Destination file exists.");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(outputFile)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line);
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
