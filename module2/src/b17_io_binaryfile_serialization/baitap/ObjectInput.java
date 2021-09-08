package b17_io_binaryfile_serialization.baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInput {
    public static void main(String[] args) {
        //input là dùng để đọc file. nó ngược lại với character stream
        try {
            FileInputStream fileInputStream=new FileInputStream("src/b17_io_binaryfile_serialization/baitap/data.dat");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            List<Product> products=(List<Product>) objectInputStream.readObject();
            for (Product product: products){
                System.out.println(product);
            }
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
