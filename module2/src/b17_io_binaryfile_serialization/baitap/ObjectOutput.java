package b17_io_binaryfile_serialization.baitap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutput {
    public static void main(String[] args) {
        //output là dùng để ghi vào file. nó ngược lại với character stream
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("src/b17_io_binaryfile_serialization/baitap/data.dat");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            List<Product> products=new ArrayList<>();
            Product product1=new Product(1,"Iphone 12 Pro max","Apple",3000000,"mới");
            Product product2=new Product(2,"Iphone XS Pro max","Apple",1500000,"mới");
            Product product3=new Product(3,"Iphone 8 Plus","Apple",1000000,"mới");
            products.add(product1);
            products.add(product2);
            products.add(product3);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
