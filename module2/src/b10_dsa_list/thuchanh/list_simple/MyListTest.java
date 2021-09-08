package b10_dsa_list.thuchanh.list_simple;

public class MyListTest {
    public static void main(String[] args) {
        // Trường hợp 1:
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

//        listInteger.get(6);
//       System.out.println("element 6: "+listInteger.get(6));
        //Trường hợp 2:
//        listInteger.get(-1);
//        System.out.println("element -1: " + listInteger.get(-1));
    }
}

