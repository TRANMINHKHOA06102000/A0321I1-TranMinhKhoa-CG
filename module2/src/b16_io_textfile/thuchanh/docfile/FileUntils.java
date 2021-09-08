package b16_io_textfile.thuchanh.docfile;

import java.io.*;

public class FileUntils {
    public static final String FILE_PATH = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\b16_io_textfile\\thuchanh\\docfile\\country.csv";
    public static final String COMMA = ",";

    public static void main(String[] args) {
        String csvFile = FILE_PATH;
        BufferedReader bufferedReader = null;
        String line = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferedReader.readLine()) != null) {
                String[] country = line.split(COMMA);
                System.out.println(country[0] + COMMA + country[1] + COMMA + country[2] + COMMA + country[3] + COMMA + country[4] + COMMA + country[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


